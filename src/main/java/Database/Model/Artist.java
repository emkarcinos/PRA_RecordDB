package Database.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "name")
@Entity
@Table(name = "artist")
public class Artist implements Serializable {

    @Id
    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne
    private ContactInfo contactInfo;

    @OneToMany(mappedBy = "artist", fetch = FetchType.LAZY)
    private Set<Album> albums = new HashSet<Album>();

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Label> labels = new ArrayList<>();

    public Artist() {
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
