package Database.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "contact_info")
public class ContactInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    private Artist artist;

    @Column(name = "webpage")
    private String webpage;

    @Column(name = "bandcamp")
    private String bandcampUrl;

    @Column(name = "spotify")
    private String spotifyUrl;

    public ContactInfo() {
    }

    public int getId() {
        return id;
    }

    public Artist getArtist() {
        return artist;
    }

    public String getWebpage() {
        return webpage;
    }

    public String getBandcampUrl() {
        return bandcampUrl;
    }

    public String getSpotifyUrl() {
        return spotifyUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    public void setBandcampUrl(String bandcampUrl) {
        this.bandcampUrl = bandcampUrl;
    }

    public void setSpotifyUrl(String spotifyUrl) {
        this.spotifyUrl = spotifyUrl;
    }


}
