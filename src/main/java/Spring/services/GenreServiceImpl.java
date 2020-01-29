package Spring.services;

import Database.Model.Album;
import Database.Model.Genre;
import Spring.repositories.AlbumRepository;
import Spring.repositories.GenreRepository;
import Spring.services.Interfaces.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    GenreRepository genreRepository;

    @Autowired
    AlbumRepository albumRepository;

    @Override
    public Iterable<Genre> listAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Iterable<Album> getAlbumsByGenreId(Integer id) {
        return albumRepository.getAlbumByGenreId(id);
    }

    @Override
    public Genre getGenreById(Integer id) {
        return genreRepository.findById(id).orElse(null);
    }

    @Override
    public Genre saveGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public void deleteGenre(Integer id) {
        genreRepository.deleteById(id);
    }

    @Override
    public Boolean checkIfExists(Integer id) {
        return genreRepository.checkIfExists((id)) > 0;
    }
}
