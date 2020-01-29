package Spring.services.Interfaces;

import Database.Model.Album;
import Database.Model.Genre;
import org.springframework.stereotype.Service;

@Service
public interface GenreService {

    Iterable<Genre> listAllGenres();

    Iterable<Album> getAlbumsByGenreId(Integer id);

    Genre getGenreById(Integer id);

    Genre saveGenre(Genre genre);

    void deleteGenre(Integer id);

    Boolean checkIfExists(Integer id);
}
