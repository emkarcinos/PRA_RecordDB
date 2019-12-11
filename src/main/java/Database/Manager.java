package Database;

import Database.Model.*;
import Database.Queries.Queries;
import Parser.JsonReader;
import Parser.JsonWriter;
import Parser.XmlReader;
import Parser.XmlWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Manager {

    public static void main(String[] args) {
        System.out.println("Starting sample session...");

        EntityManager entityManager = null;
        EntityManagerFactory entityManagerFactory = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");

            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            List<Genre> genres = JsonReader.createGenresFromJson("json/sampleGenres.json");

            for (Genre genre : genres)
                entityManager.persist(genre);

            entityManager.flush();
            entityManager.getTransaction().commit();

            entityManager.getTransaction().begin();


            List<Label> labels = JsonReader.createLabelsFromJson("json/sampleLabels.json");

            for (Label label : labels)
                entityManager.persist(label);

            List<Artist> artists = JsonReader.createArtistsFromJson("json/sampleArtists.json");

            for (Artist artist : artists)
                entityManager.persist(artist);

            entityManager.flush();

            entityManager.getTransaction().commit();
            entityManager.getTransaction().begin();

            List<AlbumType> types = JsonReader.createTypesFromJson("json/sampleTypes.json");

            for (AlbumType type : types)
                entityManager.persist(type);

            List<Album> albums = JsonReader.createAlbumsFromJson("json/sampleAlbums.json");

            for (Album album : albums)
                entityManager.persist(album);

            List<Song> songs = JsonReader.createSongsFromJson("json/sampleSongs.json");

            for (Song song : songs)
                entityManager.persist(song);

            List<ContactInfo> contacts = XmlReader.createContactInfosFromXml("xml/sampleContactInfo.xml");

            XmlWriter<Song> songXmlWriter = new XmlWriter<Song>();
            songXmlWriter.serializeList("xml/results/songs.xml", songs);

            for (ContactInfo contact : contacts)
                entityManager.persist(contact);

            entityManager.flush();

            Queries queries = new Queries(entityManager);

            JsonWriter<Album> albumJsonWriter = new JsonWriter<>();
            albumJsonWriter.serializeList("json/results/getAlbumsFromArtist.json", queries.getAlbumsFromArtist(artists.get(0)));

            JsonWriter<Song> songJsonWriter = new JsonWriter<>();
            songJsonWriter.serializeList("json/results/getSongsOnAlbum.json", queries.getSongsOnAlbum(albums.get(0)));

            entityManager.getTransaction().commit();

        } catch (Throwable ex) {
            ex.printStackTrace();
        } finally {
            entityManagerFactory.close();
        }
    }
}
