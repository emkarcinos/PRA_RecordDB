package Database.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id", scope = Artist.class)
@Entity
@Table(name = "artist")
public class Artist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private ContactInfo contactInfo;

    @OneToMany(mappedBy = "artist", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Set<Album> albums = new HashSet<Album>();

    @ManyToMany(mappedBy = "artists", fetch = FetchType.LAZY)
    private List<Label> labels = new ArrayList<>();

    public Artist() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }
}
