package system.incall.dao;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity(value = "profile", noClassnameStored = true)
public class Profile {
    public static final String ID = "id";

    @Id private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
