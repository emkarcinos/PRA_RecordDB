package Spring.controllers;

import Database.Model.Album;
import Spring.services.Interfaces.AlbumService;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @RequestMapping(value = "/albums", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Album> list(Model model) {
        return albumService.listAllAlbums();
    }

    @RequestMapping(value = "/albums", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Album> redirect(Model model) {
        return albumService.listAllAlbums();
    }

    @RequestMapping(value = "/albums/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Album getById(@PathVariable("id") Integer id) {
        return albumService.getAlbumById(id);
    }

    @RequestMapping(value = "/albums", method = RequestMethod.POST)
    public ResponseEntity<Album> create(@RequestBody @Valid @NotNull Album album) {
        albumService.saveAlbum(album);
        return ResponseEntity.ok().body(album);
    }

    @RequestMapping(value = "/albums/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(HttpServletResponse response, @PathVariable Integer id) {
        albumService.deleteAlbum(id);
        return new RedirectView("/api/albums", true);
    }

    @RequestMapping(value = "/albums", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Album album) {
        if (!albumService.checkIfExists(album.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            albumService.saveAlbum(album);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @RequestMapping(value = "/albums/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer count(Model model) {
        return albumService.albumsCount();
    }

}
