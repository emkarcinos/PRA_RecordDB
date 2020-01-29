package Spring.services.Interfaces;

import Database.Model.Album;
import Database.Model.Artist;
import Database.Model.Label;
import org.springframework.stereotype.Service;

@Service
public interface LabelService {

    Iterable<Label> listAllLabels();

    Iterable<Artist> getArtistsByLabelId(Integer id);

    Iterable<Album> getAlbumsByLabelId(Integer id);

    Label getLabelById(Integer id);

    Label saveLabel(Label label);

    void deleteLabel(Integer id);

    Boolean checkIfExists(Integer id);
}
