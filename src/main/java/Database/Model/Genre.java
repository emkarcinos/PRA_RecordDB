package Database.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "genre")
public class Genre implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Genre subgenre_of;

    public Genre() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Genre getSubgenre_of() {
        return subgenre_of;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubgenre_of(Genre subgenre_of) {
        this.subgenre_of = subgenre_of;
    }
}
