package Spring.controllers;

import Database.Model.Album;
import Database.Model.Genre;
import Spring.services.Interfaces.GenreService;
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
public class GenreController {

    @Autowired
    GenreService genreService;

    @RequestMapping(value = "/genres", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Genre> list(Model model) {
        return genreService.listAllGenres();
    }

    @RequestMapping(value = "/genres/{id}/albums", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Album> listAlbums(@PathVariable("id") Integer id) {
        return genreService.getAlbumsByGenreId(id);
    }

    @RequestMapping(value = "/genres/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Genre getById(@PathVariable("id") Integer id) {
        return genreService.getGenreById(id);
    }

    @RequestMapping(value = "/genres", method = RequestMethod.POST)
    public ResponseEntity<Genre> create(@RequestBody @Valid @NotNull Genre genre) {
        genreService.saveGenre(genre);
        return ResponseEntity.ok().body(genre);
    }

    @RequestMapping(value = "/genres/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(HttpServletResponse response, @PathVariable Integer id) {
        genreService.deleteGenre(id);
        return new RedirectView("/api/genres", true);
    }

    @RequestMapping(value = "/genres", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Genre genre) {
        if (!genreService.checkIfExists(genre.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            genreService.saveGenre(genre);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @RequestMapping(value = "/genres/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer count(){
        return genreService.getCount();
    }

}
