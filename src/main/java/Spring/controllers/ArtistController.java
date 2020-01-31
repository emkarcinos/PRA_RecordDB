package Spring.controllers;

import Database.Model.Artist;
import Spring.services.Interfaces.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @RequestMapping(value = "/artists", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Artist> list(Model model) {
        return artistService.listAllArtists();
    }

    @RequestMapping(value = "/artists", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Artist> redirect(Model model) {
        return artistService.listAllArtists();
    }

    @RequestMapping(value = "/artists/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Artist getById(@PathVariable("id") Integer id) {
        return artistService.getArtistById(id);
    }

    @RequestMapping(value = "/artists", method = RequestMethod.POST)
    public ResponseEntity<Artist> create(@RequestBody @Valid @NotNull Artist artist) {
        artistService.saveArtist(artist);
        return ResponseEntity.ok().body(artist);
    }

    @RequestMapping(value = "/artists/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RedirectView delete(HttpServletResponse response, @PathVariable Integer id) {
        artistService.deleteAlbum(id);
        return new RedirectView("/api/artists", true);
    }

    @RequestMapping(value = "/artists", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Artist artist) {
        if (!artistService.checkIfExists(artist.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            artistService.saveArtist(artist);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @RequestMapping(value = "/artists/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer count(Model model) {
        return artistService.getCount();
    }

}
