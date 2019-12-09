package Database.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "song")
@IdClass(SongCompositeKey.class)
public class Song implements Serializable {

    @Id
    @Column(name = "disc")
    private int disc;

    @Id
    @Column(name = "number")
    private int number;

    @Column(name = "name", nullable = false)
    private String name;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    private Album album;

    public Song() {
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
