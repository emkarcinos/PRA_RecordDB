package Spring.repositories;

import Database.Model.Album;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Integer>, PagingAndSortingRepository<Album, Integer> {

    Optional<Album> findById(Integer id);

    @Query("select count(*) from Album a where a.id = ?1")
    Integer checkIfExist(Integer id);

}
