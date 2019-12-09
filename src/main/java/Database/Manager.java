package Database;

import Database.Model.Album;
import Database.Model.Artist;
import Database.Model.Genre;
import Database.Model.Label;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Manager {

    public static void main(String[] args){
        System.out.println("Starting sample session...");

        EntityManager entityManager = null;
        EntityManagerFactory entityManagerFactory = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");

            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            List<Label> labels = JSON.Reader.createLabelsFromJson("json/sampleLabels.json");

            for(Label label : labels)
                entityManager.persist(label);

            List<Genre> genres = JSON.Reader.createGenresFromJson("json/sampleGenres.json");

            for(Genre genre : genres)
                entityManager.persist(genre);

            List<Artist> artists = JSON.Reader.createArtistsFromJson("json/sampleArtists.json");

            for(Artist artist : artists)
                entityManager.persist(artist);

            List<Album> albums = JSON.Reader.createAlbumsFromJson("json/sampleAlbums.json");

            //for(Album album : albums)
            //    entityManager.persist(album);

            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Throwable ex){
            ex.printStackTrace();
        } finally {
            entityManagerFactory.close();
        }
    }
}
