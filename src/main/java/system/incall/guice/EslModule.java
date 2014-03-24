package system.incall.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import org.freeswitch.esl.client.inbound.Client;
import org.freeswitch.esl.client.inbound.InboundConnectionFailure;
import system.incall.App;

public class EslModule extends AbstractModule {
    private static final int TIMEOUT_SECONDS = 2;

    @Override
    protected void configure() {
        bind(String.class)
                .annotatedWith(Names.named("esl-host"))
                .toInstance(App.properties.getProperty("esl.host"));
        bind(Integer.class)
                .annotatedWith(Names.named("esl-port"))
                .toInstance(Integer.parseInt(App.properties.getProperty("esl.port")));
        bind(String.class)
                .annotatedWith(Names.named("esl-pwd"))
                .toInstance(App.properties.getProperty("esl.pwd"));
    }

    @Provides
    @Singleton
    public Client provideEslClient(@Named("esl-host") String host, @Named("esl-port") int port, @Named("esl-pwd") String pwd) throws InboundConnectionFailure {
        Client eslClient = new Client();
        eslClient.connect(host, port, pwd, TIMEOUT_SECONDS);
        return eslClient;
    }
}
