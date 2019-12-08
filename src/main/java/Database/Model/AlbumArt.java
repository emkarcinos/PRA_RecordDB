package Database.Model;

import javax.persistence.*;

@Entity
@Table(name = "album_art")
public class AlbumArt {
    @Id
    @OneToOne
    @Column(name = "album_id")
    private Album album_id;

    @Column(name = "name")
    private String name;

    @Column(name = "path")
    private String path;
}
