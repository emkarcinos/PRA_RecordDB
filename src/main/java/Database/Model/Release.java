package Database.Model;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "release")
public class Release implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "year")
    private DateTime year;

    @Column(name = "format")
    private String format;

    @ManyToOne(fetch = FetchType.LAZY)
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
