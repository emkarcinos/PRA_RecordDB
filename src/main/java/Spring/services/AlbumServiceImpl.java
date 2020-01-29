package Spring.services;

import Database.Model.Album;
import Spring.repositories.AlbumRepository;
import Spring.services.Interfaces.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public Iterable<Album> listAllAlbums() {
        return albumRepository.findAll();
    }

    @Override
    public Album getAlbumById(Integer id) {
        return albumRepository.findById(id).orElse(null);
    }

    @Override
    public Album saveAlbum(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public void deleteAlbum(Integer id) {
        albumRepository.deleteById(id);
    }

    @Override
    public Iterable<Album> listAllAlbumsPaging(Integer pageNr, Integer howManyOnPage) {
        return albumRepository.findAll(PageRequest.of(pageNr, howManyOnPage));
    }

    @Override
    public Boolean checkIfExists(Integer id) {
        return albumRepository.checkIfExist((id)) > 0;
    }
}
