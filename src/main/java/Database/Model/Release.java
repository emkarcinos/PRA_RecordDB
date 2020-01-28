package Database.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id", scope = Release.class)
@Entity
@Table(name = "release")
public class Release implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-dd-MM")
    @Column(name = "year")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime year;

    @Column(name = "format")
    private String format;

    @ManyToOne(fetch = FetchType.EAGER)
    private Album album;

    public Release() {
    }

    public int getId() {
        return id;
    }

    public DateTime getYear() {
        return year;
    }

    public String getFormat() {
        return format;
    }

    public Album getAlbum() {
        return album;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setYear(DateTime year) {
        this.year = year;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
