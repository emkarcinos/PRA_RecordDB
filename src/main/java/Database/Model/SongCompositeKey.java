package Database.Model;

import java.io.Serializable;

public class SongCompositeKey implements Serializable {
    private int disc;
    private int number;
    private Album album;
}
