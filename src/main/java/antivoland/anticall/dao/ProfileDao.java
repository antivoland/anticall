package antivoland.anticall.dao;

public interface ProfileDao {
    boolean exists(String userId);
    Profile get(String userId);
    void save(Profile profile);
    void delete(String userId);
}
