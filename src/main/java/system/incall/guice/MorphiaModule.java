package system.incall.guice;

import com.google.code.morphia.Morphia;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import com.mongodb.Mongo;
import system.incall.App;
import system.incall.dao.Profile;

import java.net.UnknownHostException;

public class MorphiaModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(String.class)
                .annotatedWith(Names.named("mongo-host"))
                .toInstance(App.properties.getProperty("mongo.host"));
        bind(Integer.class)
                .annotatedWith(Names.named("mongo-port"))
                .toInstance(Integer.parseInt(App.properties.getProperty("mongo.port")));
        bind(String.class)
                .annotatedWith(Names.named("mongo-dbName"))
                .toInstance(App.properties.getProperty("mongo.dbName"));
    }

    @Provides
    @Singleton
    Morphia provideMorphia(Mongo mongo, @Named("mongo-dbName") String dbName) {
        Morphia morphia = new Morphia();
        morphia.map(Profile.class);
        morphia.createDatastore(mongo, dbName).ensureIndexes();
        return morphia;
    }

    @Provides
    @Singleton
    Mongo provideMongo(@Named("mongo-host") String host, @Named("mongo-port") int port) throws UnknownHostException {
        return new Mongo(host, port);
    }
}
