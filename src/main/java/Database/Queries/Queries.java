package Database.Queries;

import Database.Model.Album;
import Database.Model.Artist;
import Database.Model.Genre;
import Database.Model.Song;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class Queries {
    private EntityManager entityManager;

    public Queries(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Album> getAlbumsFromArtist(Artist artist) {
        TypedQuery<Album> query = entityManager.createQuery(
                "SELECT a FROM Album a WHERE a.artist = :artist ORDER BY a.name ASC", Album.class);
        return query.setParameter("artist", artist).getResultList();
    }

    public List<Song> getSongsOnAlbum(Album album) {
        TypedQuery<Song> query = entityManager.createQuery(
                "SELECT s FROM Song s WHERE s.album = :album ORDER BY s.disc ASC, s.number ASC", Song.class);
        return query.setParameter("album", album).getResultList();
    }

    public List<Album> getAllAlbumsByGenre(Genre genre, int pageNr) {
        Query queryTotal = entityManager.createQuery("SELECT COUNT(a) FROM Album a WHERE a.genre = :genre ");
        long countResult = (long) queryTotal.setParameter("genre", genre).getSingleResult();
        Query query = entityManager.createQuery("SELECT a FROM Album a WHERE a.genre = :genre").setParameter("genre", genre);
        int pageSize = 10;
        int pageNumber = (int) ((countResult / pageSize) + 1);
        if (pageNr > pageNumber) pageNr = pageNumber;
        query.setFirstResult((pageNr - 1) * pageSize);
        query.setMaxResults(pageSize);

        return query.getResultList();
    }

    public Artist getArtistByName(String artistName) {
        TypedQuery<Artist> query = entityManager.createQuery(
                "SELECT a FROM Artist a WHERE a.name = :name", Artist.class);
        return query.setParameter("name", artistName).getSingleResult();
    }

    public List<Artist> getArtistGenres(Artist artist) {
        TypedQuery<Artist> query = entityManager.createQuery(
                "SELECT DISTINCT g FROM Artist ar INNER JOIN Album a ON a.artist = :artist INNER JOIN Genre g ON a.genre = g", Artist.class);
        return query.setParameter("artist", artist).getResultList();
    }
}
