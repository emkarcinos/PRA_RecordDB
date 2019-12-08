package Database.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "label")
public class Label {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "webpage")
    private String webpage;

    @ManyToMany(mappedBy = "labels", fetch = FetchType.LAZY)
    private List<Artist> artists = new ArrayList<>();

    @OneToMany(mappedBy = "label", fetch = FetchType.LAZY)
    private Set<Album> albums = new HashSet<>();

}
