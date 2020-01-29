package Spring.controllers;

import Database.Model.Release;
import Spring.services.Interfaces.ReleaseService;
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
public class ReleaseController {

    @Autowired
    ReleaseService releaseService;

    @RequestMapping(value = "/releases", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Release> list(Model model) {
        return releaseService.listAllReleases();
    }

    @RequestMapping(value = "/releases{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Release getById(@PathVariable("id") Integer id) {
        return releaseService.getReleaseById(id);
    }

    @RequestMapping(value = "/releases", method = RequestMethod.POST)
    public ResponseEntity<Release> create(@RequestBody @Valid @NotNull Release release) {
        releaseService.saveRelease(release);
        return ResponseEntity.ok().body(release);
    }

    @RequestMapping(value = "/releases", method = RequestMethod.PUT)
    public ResponseEntity<Release> edit(@RequestBody @Valid @NotNull Release release){
        if (!releaseService.checkIfExists(release.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            releaseService.saveRelease(release);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @RequestMapping(value = "/releases/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(HttpServletResponse response, @PathVariable Integer id) {
        releaseService.deleteRelease(id);
        return new RedirectView("/api/releases", true);
    }

}
