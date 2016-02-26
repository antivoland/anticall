package antivoland.anticall.dao;

import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.mongodb.Mongo;

public class ProfileDaoMorphiaImpl implements ProfileDao {
    private final BasicDAO<Profile, String> morphiaDAO;

    @Inject
    public ProfileDaoMorphiaImpl(Mongo mongo, Morphia morphia, @Named("mongo-dbName") String dbName) {
        this.morphiaDAO = new BasicDAO<Profile, String>(Profile.class, mongo, morphia, dbName);
    }

    @Override
    public boolean exists(String userId) {
        return morphiaDAO.exists(Profile.ID, userId);
    }

    @Override
    public Profile get(String userId) {
        return morphiaDAO.get(userId);
    }

    @Override
    public void save(Profile profile) {
        morphiaDAO.save(profile);
    }

    @Override
    public void delete(String userId) {
        morphiaDAO.deleteById(userId);
    }
}
