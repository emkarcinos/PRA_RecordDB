package Database.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Table(name = "label")
public class Label implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "webpage")
    private String webpage;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private List<Artist> artists = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "label", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Set<Album> albums = new HashSet<>();

    public Label() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWebpage() {
        return webpage;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }
}
