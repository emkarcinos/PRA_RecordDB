package Spring.services;

import Database.Model.Artist;
import Spring.repositories.ArtistRepository;
import Spring.services.Interfaces.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public Iterable<Artist> listAllArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Artist getArtistById(Integer id) {
        return artistRepository.findById(id).orElse(null);
    }

    @Override
    public Artist saveArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public void deleteAlbum(Integer id) {
        artistRepository.deleteById(id);
    }

    @Override
    public Boolean checkIfExists(Integer id) {
        return artistRepository.checkIfExists((id)) > 0;
    }

    @Override
    public Integer getCount() {
        return artistRepository.getArtistsCount();
    }
}
