package Database.Model;

import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Table(name = "release")
public class Release {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "year")
    private DateTime year;

    @Column(name = "format")
    private String format;

}
