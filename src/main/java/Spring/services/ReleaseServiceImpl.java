package Spring.services;

import Database.Model.Release;
import Spring.repositories.ReleaseRepository;
import Spring.services.Interfaces.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReleaseServiceImpl implements ReleaseService {

    @Autowired
    ReleaseRepository releaseRepository;

    @Override
    public Iterable<Release> listAllReleases() {
        return releaseRepository.findAll();
    }

    @Override
    public Release getReleaseById(Integer id) {
        return releaseRepository.findById(id).orElse(null);
    }

    @Override
    public Release saveRelease(Release release) {
        return releaseRepository.save(release);
    }

    @Override
    public void deleteRelease(Integer id) {
        releaseRepository.deleteById(id);
    }

    @Override
    public Boolean checkIfExists(Integer id) {
        return releaseRepository.checkIfExists((id)) > 0;
    }
}
