package Database.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "song")
@IdClass(SongCompositeKey.class)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id", scope = Song.class)
public class Song implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "disc")
    private int disc;

    @Column(name = "number")
    private int number;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Album album;

    public Song() {
    }

    public long getId() {
        return id;
    }

    public int getDisc() {
        return disc;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Album getAlbum() {
        return album;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDisc(int disc) {
        this.disc = disc;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
