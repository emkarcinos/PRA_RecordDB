package Database.Queries;

import Database.Model.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class Queries {
    private EntityManager entityManager;

    public Queries(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Album> getAlbumsFromArtist(Artist artist){
        TypedQuery<Album> query = entityManager.createQuery(
                "SELECT a FROM Album a WHERE a.artist = :artist ORDER BY a.name ASC", Album.class);
        return query.setParameter("artist", artist).getResultList();
    }

    public List<Song> getSongsOnAlbum(Album album){
        TypedQuery<Song> query = entityManager.createQuery(
                "SELECT s FROM Song s WHERE s.album = :album  ORDER BY s.disc ASC, s.number ASC", Song.class);
        return query.setParameter("album", album).getResultList();
    }

    public List<Album> getAllAlbumsByGenre(Genre genre, int pageNr){
        Query queryTotal = entityManager.createQuery("SELECT COUNT(a) FROM Album a WHERE a.genre = :genre ");
        long countResult = (long)queryTotal.setParameter("genre", genre).getSingleResult();
        Query query = entityManager.createQuery("SELECT a FROM Album a WHERE a.genre = :genre").setParameter("genre", genre);
        int pageSize = 10;
        int pageNumber = (int) ((countResult / pageSize) + 1);
        if (pageNr > pageNumber) pageNr = pageNumber;
        query.setFirstResult((pageNr-1) * pageSize);
        query.setMaxResults(pageSize);

        return query.getResultList();
    }

    public List<Release> getAlbumReleases(Album album){
        TypedQuery<Release> query = entityManager.createQuery(
                "SELECT r FROM Release r WHERE r.album = :album", Release.class);
        return query.setParameter("album", album).getResultList();
    }

    public List<Artist> getLabelArtists(Label label){
        TypedQuery<Artist> query = entityManager.createQuery(
                "SELECT a FROM Artist a WHERE :label MEMBER OF a.labels ", Artist.class);
        return query.setParameter("label", label).getResultList();
    }
}
