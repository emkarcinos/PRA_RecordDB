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
                "SELECT a FROM album a WHERE a.artist_name LIKE " + artist.getName() + " ORDER BY a.name ASC", Album.class);
        return query.getResultList();
    }

    public List<Song> getSongsOnAlbum(Album album){
        TypedQuery<Song> query = entityManager.createQuery(
                "SELECT s FROM song WHERE s.album_id = " + album.getId() + " ORDER BY s.disc ASC, s.number ASC", Song.class);
        return query.getResultList();
    }

    public List<Album> getAllAlbumsByGenre(Genre genre, int pageNr){
        Query queryTotal = entityManager.createQuery
                ("SELECT COUNT(a) FROM album a WHERE a.genre = " + genre.getId());
        long countResult = (long)queryTotal.getSingleResult();
        Query query = entityManager.createQuery("SELECT a FROM album a WHERE a.genre = " + genre.getId());
        int pageSize = 10;
        int pageNumber = (int) ((countResult / pageSize) + 1);
        if (pageNr > pageNumber) pageNr = pageNumber;
        query.setFirstResult((pageNr-1) * pageSize);
        query.setMaxResults(pageSize);

        return query.getResultList();
    }

    public List<Release> getAlbumReleases(Album album){
        TypedQuery<Release> query = entityManager.createQuery(
                "SELECT r FROM release r WHERE r.album_id = " + album.getId(), Release.class);
        return query.getResultList();
    }

    public List<Artist> getLabelArtists(Label label){
        TypedQuery<Artist> query = entityManager.createQuery(
                "SELECT a FROM artist a INNER JOIN artist_label al ON a.name = al.artist_name WHERE al.labels_id = " + label.getId(), Artist.class);
        return query.getResultList();
    }
}
