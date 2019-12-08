package Database.Model;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "album")
public class Album implements Serializable {

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
    private Artist artist;

    @ManyToOne(fetch = FetchType.LAZY)
    private Label label;

    @ManyToOne(fetch = FetchType.LAZY)
    private Type type;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<Song> songs = new ArrayList<Song>();

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<Release> releases = new ArrayList<>();

    @OneToOne(mappedBy = "album")
    private AlbumArt albumArt;

    public Album() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public DateTime getYear() {
        return year;
    }

    public Genre getGenre() {
        return genre;
    }

    public Artist getArtist() {
        return artist;
    }

    public Label getLabel() {
        return label;
    }

    public Type getType() {
        return type;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public List<Release> getReleases() {
        return releases;
    }

    public AlbumArt getAlbumArt() {
        return albumArt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(DateTime year) {
        this.year = year;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void setReleases(List<Release> releases) {
        this.releases = releases;
    }

    public void setAlbumArt(AlbumArt albumArt) {
        this.albumArt = albumArt;
    }
}
