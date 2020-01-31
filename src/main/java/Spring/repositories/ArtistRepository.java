package Spring.repositories;

import Database.Model.Artist;
import Database.Model.Label;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Integer>, PagingAndSortingRepository<Artist, Integer> {

    Optional<Artist> findById(Integer id);

    @Query("SELECT COUNT(*) FROM Artist a WHERE a.id = ?1")
    Integer checkIfExists(Integer id);

    Iterable<Artist> getArtistByLabels(Label label);

    @Query("SELECT COUNT(*) FROM Artist ")
    Integer getArtistsCount();
}
