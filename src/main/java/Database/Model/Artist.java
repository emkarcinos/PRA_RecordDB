package Database.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "artist")
public class Artist {

    @Id
    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne
    @Column(name = "concact")
    private ContactInfo contactInfo;

    @OneToMany(mappedBy = "artist", fetch = FetchType.LAZY)
    private Set<Album> albums = new HashSet<Album>();

    @ManyToMany(mappedBy = "artists", fetch = FetchType.LAZY)
    private List<Label> labels = new ArrayList<>();
}
