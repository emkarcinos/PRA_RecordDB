package Database.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "album", scope = AlbumArt.class)
@Entity
@Table(name = "album_art")
public class AlbumArt implements Serializable {
    @Id
    @OneToOne
    private Album album;

    @Column(name = "name")
    private String name;

    @Column(name = "path")
    private String path;

    public AlbumArt() {
    }

    public Album getAlbum() {
        return album;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
