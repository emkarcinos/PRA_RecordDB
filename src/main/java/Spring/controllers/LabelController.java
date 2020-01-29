package Spring.controllers;

import Database.Model.Album;
import Database.Model.Artist;
import Database.Model.Label;
import Spring.services.Interfaces.LabelService;
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
public class LabelController {

    @Autowired
    LabelService labelService;

    @RequestMapping(value = "/labels", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Label> list(Model model) {
        return labelService.listAllLabels();
    }

    @RequestMapping(value = "/labels/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Label getById(@PathVariable("id") Integer id) {
        return labelService.getLabelById(id);
    }

    @RequestMapping(value = "/labels/{id}/albums", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Album> getLabelAlbums(@PathVariable("id") Integer id) {
        return labelService.getAlbumsByLabelId(id);
    }

    @RequestMapping(value = "/labels/{id}/artists", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Artist> getLabelArtists(@PathVariable("id") Integer id) {
        return labelService.getArtistsByLabelId(id);
    }

    @RequestMapping(value = "/labels", method = RequestMethod.POST)
    public ResponseEntity<Label> create(@RequestBody @Valid @NotNull Label label) {
        labelService.saveLabel(label);
        return ResponseEntity.ok().body(label);
    }

    @RequestMapping(value = "/labels", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Label label) {
        if(!labelService.checkIfExists(label.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            labelService.saveLabel(label);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @RequestMapping(value = "/labels/{id}", method = RequestMethod.DELETE)
    public RedirectView delete (HttpServletResponse response, @PathVariable Integer id) {
        labelService.deleteLabel(id);
        return new RedirectView("/api/labels", true);
    }
}
