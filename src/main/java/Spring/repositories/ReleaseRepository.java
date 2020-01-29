package Spring.repositories;

import Database.Model.Release;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReleaseRepository extends CrudRepository<Release, Integer>, PagingAndSortingRepository<Release, Integer> {

    Optional<Release> findById(Integer id);

    @Query("SELECT COUNT(*) FROM Release r WHERE r.id = ?1")
    Integer checkIfExists(Integer id);
}
