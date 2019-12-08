package Database.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "type")
public class Type {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY)
    private List<Album> albums = new ArrayList<>();
}
