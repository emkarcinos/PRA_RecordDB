package Database.Model;

import javax.persistence.*;

@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "subgenre_of")
    private Genre subgenre_of;

}
