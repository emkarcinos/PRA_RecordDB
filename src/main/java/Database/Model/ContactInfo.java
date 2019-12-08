package Database.Model;

import javax.persistence.*;

@Entity
@Table(name = "contact_info")
public class ContactInfo {

    @Id
    @OneToOne
    @Column(name = "artist_name")
    private Artist artist;

    @Column(name = "webpage")
    private String webpage;

    @Column(name = "bandcamp")
    private String bandcampUrl;

    @Column(name = "spotify")
    private String spotifyUrl;
}
