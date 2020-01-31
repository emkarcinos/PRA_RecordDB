package Spring.repositories;

import Database.Model.Genre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Integer>, PagingAndSortingRepository<Genre, Integer> {

    Optional<Genre> findById(Integer id);

    @Query("SELECT COUNT(*) FROM Genre g WHERE g.id = ?1")
    Integer checkIfExists(Integer id);

    @Query("SELECT COUNT(*) FROM Genre")
    Integer getGenresCount();
}
