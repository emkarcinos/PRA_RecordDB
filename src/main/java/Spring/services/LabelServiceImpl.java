package Spring.services;

import Database.Model.Album;
import Database.Model.Artist;
import Database.Model.Label;
import Spring.repositories.AlbumRepository;
import Spring.repositories.ArtistRepository;
import Spring.repositories.LabelRepository;
import Spring.services.Interfaces.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    LabelRepository labelRepository;

    @Autowired
    ArtistRepository artistRepository;

    @Autowired
    AlbumRepository albumRepository;

    @Override
    public Iterable<Label> listAllLabels() {
        return labelRepository.findAll();
    }

    @Override
    public Iterable<Artist> getArtistsByLabelId(Integer id) {
        return artistRepository.getArtistByLabels(labelRepository.findById(id).orElse(null));
    }

    @Override
    public Iterable<Album> getAlbumsByLabelId(Integer id) {
        return albumRepository.getAlbumByLabelId(id);
    }

    @Override
    public Label getLabelById(Integer id) {
        return labelRepository.findById(id).orElse(null);
    }

    @Override
    public Label saveLabel(Label label) {
        return labelRepository.save(label);
    }

    @Override
    public void deleteLabel(Integer id) {
        labelRepository.deleteById(id);
    }

    @Override
    public Boolean checkIfExists(Integer id) {
        return labelRepository.checkIfExists((id)) > 0;
    }
}
