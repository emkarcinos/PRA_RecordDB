package Database.Model;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "album")

public class Album {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "year")
    private DateTime year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre")
    private Genre genre;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "artist", nullable = false)
    private Artist artist;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "label")
    private Label label;

    @ManyToOne(fetch = FetchType.LAZY)
    private Type type;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<Song> songs = new ArrayList<Song>();

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<Release> releases = new ArrayList<>();
}
