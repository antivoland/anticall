package system.incall;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import org.codehaus.jackson.map.ObjectMapper;
import org.freeswitch.esl.client.IEslEventListener;
import org.freeswitch.esl.client.inbound.Client;
import org.freeswitch.esl.client.transport.event.EslEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import system.incall.dao.ProfileDao;
import system.incall.dao.ProfileDaoMorphiaImpl;
import system.incall.guice.EslModule;
import system.incall.guice.MorphiaModule;
import system.incall.model.Event;
import system.incall.model.EventHandler;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        App.properties = new Properties();
        App.properties.load(new FileInputStream("conf/incall.properties"));
        App.injector = Guice.createInjector(new EslModule(), new MorphiaModule(), new AbstractModule() {
            @Override
            protected void configure() {
                bind(ProfileDao.class).to(ProfileDaoMorphiaImpl.class);
            }
        });

        Client eslClient = App.injector.getInstance(Client.class);
        eslClient.setEventSubscriptions("plain", "all");

        /*Event.API.setHandler(new EventHandler() {
            @Override
            public void handle(EslEvent event) {
                log.info("Handle API event");
            }
        });*/

        Event.CUSTOM.setHandler(new EventHandler() {
            @Override
            public void handle(EslEvent event) {
                // do nothing
            }
        });

        eslClient.addEventListener(new IEslEventListener() {
            @Override
            public void eventReceived(EslEvent event) {
                if (!Event.valueOf(event.getEventName()).handle(event)) {
                    traceEvent(event);
                }
            }

            @Override
            public void backgroundJobResultReceived(EslEvent event) {
                log.info("Background job result received [{}]", event);
                traceEvent(event);
            }
        });

        eslClient.sendSyncApiCommand("echo", "Foo foo bar");
    }

    private static void traceEvent(EslEvent event) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            log.debug(mapper.writeValueAsString(event));
        } catch (IOException e) {
            log.warn(e.getMessage());
        }
        log.info("================================================================================");
    }
}
