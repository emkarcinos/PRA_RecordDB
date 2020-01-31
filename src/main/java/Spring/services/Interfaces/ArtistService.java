package Spring.services.Interfaces;

import Database.Model.Artist;
import org.springframework.stereotype.Service;

@Service
public interface ArtistService {

    Iterable<Artist> listAllArtists();

    Artist getArtistById(Integer id);

    Artist saveArtist(Artist artist);

    void deleteAlbum(Integer id);

    Boolean checkIfExists(Integer id);

    Integer getCount();
}
