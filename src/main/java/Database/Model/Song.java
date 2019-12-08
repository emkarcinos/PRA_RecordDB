package Database.Model;

import javax.persistence.*;

@Entity
@Table(name = "song")
public class Song {

    @Id
    @Column(name = "disc")
    private int disc;

    @Id
    @Column(name = "number")
    private int number;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Album album;

}
