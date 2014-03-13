package system.incall;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import org.freeswitch.esl.client.inbound.Client;
import org.freeswitch.esl.client.inbound.InboundConnectionFailure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.util.Properties;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        log.info("It's alive!");
        App.properties = new Properties();
        App.properties.load(new FileInputStream("conf/incall.properties"));
        App.injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                String host = App.properties.getProperty("esl.host");
                int port = Integer.parseInt(App.properties.getProperty("esl.port"));
                String pwd = App.properties.getProperty("esl.pwd");
                Client client = new Client();
                try {
                    client.connect(host, port, pwd, 2);
                } catch (InboundConnectionFailure e) {
                    throw new Error(e);
                }
                bind(Client.class).toInstance(client);
            }
        });
    }
}
