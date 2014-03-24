package system.incall;

import com.google.inject.Guice;
import org.freeswitch.esl.client.IEslEventListener;
import org.freeswitch.esl.client.inbound.Client;
import org.freeswitch.esl.client.transport.event.EslEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import system.incall.guice.EslModule;
import system.incall.guice.MorphiaModule;
import system.incall.model.Event;
import system.incall.model.EventConsumer;

import java.io.FileInputStream;
import java.util.Properties;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        App.properties = new Properties();
        App.properties.load(new FileInputStream("conf/incall.properties"));
        App.injector = Guice.createInjector(new EslModule(), new MorphiaModule());

        Client eslClient = App.injector.getInstance(Client.class);
        eslClient.setEventSubscriptions("plain", "all");

        Event.API.setConsumer(new EventConsumer() {
            @Override
            public void consume(EslEvent event) {
                // log.info(event.toString());
            }
        });

        eslClient.addEventListener(new IEslEventListener() {
            @Override
            public void eventReceived(EslEvent event) {
                Event.valueOf(event.getEventName()).consume(event);
                log.info("================================================================================");
            }

            @Override
            public void backgroundJobResultReceived(EslEvent event) {
                log.info("Background job result received [{}]", event);
            }
        });

        eslClient.sendSyncApiCommand("echo", "Foo foo bar");
    }
}
