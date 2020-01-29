package Spring.repositories;

import Database.Model.Label;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LabelRepository extends CrudRepository<Label, Integer>, PagingAndSortingRepository<Label, Integer> {

    Optional<Label> findById(Integer id);

    @Query("SELECT COUNT (*) FROM Genre g WHERE g.id = ?1")
    Integer checkIfExists(Integer id);
}
