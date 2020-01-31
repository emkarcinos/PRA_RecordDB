package Spring.services.Interfaces;

import Database.Model.Album;
import org.springframework.stereotype.Service;

@Service
public interface AlbumService {

    Iterable<Album> listAllAlbums();

    Album getAlbumById(Integer id);

    Album saveAlbum(Album album);

    void deleteAlbum(Integer id);

    public Iterable<Album> listAllAlbumsPaging(Integer pageNr, Integer howManyOnPage);

    Boolean checkIfExists(Integer id);

    Integer albumsCount();
}
