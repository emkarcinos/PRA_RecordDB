package Spring.services.Interfaces;

import Database.Model.Release;
import org.springframework.stereotype.Service;

@Service
public interface ReleaseService {

    Iterable<Release> listAllReleases();

    Release getReleaseById(Integer id);

    Release saveRelease(Release release);

    void deleteRelease(Integer id);

    Boolean checkIfExists(Integer id);
}
