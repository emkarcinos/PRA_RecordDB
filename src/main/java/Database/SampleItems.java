package Database;

import Database.Model.*;
import Database.Queries.Queries;
import JSON.Writer;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SampleItems {
    public static void create(EntityManager manager) {
        Label label1 = new Label();
        label1.setName("ECM");
        label1.setWebpage("https://www.ecmrecords.com");

        Label label2 = new Label();
        label2.setName("Kscope");
        label2.setWebpage("https://kscopemusic.com");

        List<Label> labels = new ArrayList<Label>();
        labels.add(label1);
        labels.add(label2);

        for (Label label : labels)
            manager.persist(label);

        Genre genre1 = new Genre();
        genre1.setId(1);
        genre1.setName("Jazz");

        Genre genre2 = new Genre();
        genre2.setId(2);
        genre2.setName("Jazz Fusion");
        genre2.setSubgenre_of(genre1);

        Genre genre3 = new Genre();
        genre3.setId(3);
        genre3.setName("Contemporary Jazz");
        genre3.setSubgenre_of(genre1);

        Genre genre4 = new Genre();
        genre4.setId(4);
        genre4.setName("Rock");

        Genre genre5 = new Genre();
        genre5.setId(5);
        genre5.setName("Progressive Rock");
        genre5.setSubgenre_of(genre4);

        Genre genre6 = new Genre();
        genre6.setId(6);
        genre6.setName("Math Rock");
        genre6.setSubgenre_of(genre5);

        Genre genre7 = new Genre();
        genre7.setId(7);
        genre7.setName("Avant-grade Jazz");
        genre7.setSubgenre_of(genre1);

        List<Genre> genres = new ArrayList<Genre>();
        genres.add(genre1);
        genres.add(genre2);
        genres.add(genre3);
        genres.add(genre4);
        genres.add(genre5);
        genres.add(genre6);
        genres.add(genre7);

        for (Genre genre : genres)
            manager.persist(genre);

        Artist artist1 = new Artist();
        artist1.setName("Steven Wilson");
        List<Label> a1Labels = new ArrayList<>();
        a1Labels.add(label2);
        artist1.setLabels(a1Labels);


        Artist artist2 = new Artist();
        artist2.setName("Tesseract");
        artist2.setLabels(a1Labels);


        Artist artist3 = new Artist();
        artist3.setName("Tomasz Stańko");
        List<Label> a2Labels = new ArrayList<>();
        a2Labels.add(label2);
        artist3.setLabels(a2Labels);

        Artist artist4 = new Artist();
        artist4.setName("Pat Metheny");
        artist4.setLabels(a2Labels);


        List<Artist> artists = new ArrayList<>();
        artists.add(artist1);
        artists.add(artist2);
        artists.add(artist3);
        artists.add(artist4);

        for (Artist artist : artists)
            manager.persist(artist);
        manager.flush();

            /*
        ContactInfo contact2 = new ContactInfo();
        artist2.setContactInfo(contact2);
        contact2.setWebpage("https://www.tesseractband.co.uk");
        contact2.setSpotifyUrl("https://open.spotify.com/artist/23ytwhG1pzX6DIVWRWvW1r");
        manager.persist(contact2);

        ContactInfo contact1 = new ContactInfo();
        artist1.setContactInfo(contact1);
        contact1.setWebpage("http://stevenwilsonhq.com/sw/");
        contact1.setSpotifyUrl("https://open.spotify.com/artist/4X42BfuhWCAZ2swiVze9O0");
        manager.persist(contact1);

        ContactInfo contact4 = new ContactInfo();
        artist4.setContactInfo(contact4);
        contact4.setWebpage("http://www.patmetheny.com");
        contact4.setSpotifyUrl("https://open.spotify.com/artist/3t58jfUhoMLYVO14XaUFLA");
        manager.persist(contact4);
        */
        AlbumType type1 = new AlbumType();
        type1.setId(1);
        type1.setName("Album");

        AlbumType type2 = new AlbumType();
        type2.setId(2);
        type2.setName("EP");

        AlbumType type3 = new AlbumType();
        type3.setId(3);
        type3.setName("Re-release");

        List<AlbumType> albumTypes = new ArrayList<>();
        albumTypes.add(type1);
        albumTypes.add(type2);
        albumTypes.add(type3);

        for (AlbumType type : albumTypes)
            manager.persist(type);
        manager.flush();

        Album album1 = new Album();
        album1.setName("Litania: Music of Krzysztof Komeda");
        album1.setYear(new DateTime("1997-02-01"));
        album1.setGenre(genre7);
        album1.setArtist(artist3);
        album1.setLabel(label1);
        album1.setType(type1);

        Album album2 = new Album();
        album2.setName("The Raven that Refused to Sing");
        album2.setYear(new DateTime("2013-02-25"));
        album2.setGenre(genre4);
        album2.setArtist(artist1);
        album2.setLabel(label2);
        album2.setType(type1);

        List<Album> albums = new ArrayList<>();
        albums.add(album1);
        albums.add(album2);

        for (Album album : albums)
            manager.persist(album);
        manager.flush();

        Song song11 = new Song();
        song11.setDisc(1);
        song11.setNumber(1);
        song11.setAlbum(album1);
        song11.setName("Svantetic");

        Song song12 = new Song();
        song12.setDisc(1);
        song12.setNumber(2);
        song12.setAlbum(album1);
        song12.setName("Sleep Safe and Warm");

        Song song13 = new Song();
        song13.setDisc(1);
        song13.setNumber(3);
        song13.setAlbum(album1);
        song13.setName("Night-Time, Daytime Requiem");

        Song song14 = new Song();
        song14.setDisc(1);
        song14.setNumber(4);
        song14.setAlbum(album1);
        song14.setName("Ballada");

        Song song15 = new Song();
        song15.setDisc(1);
        song15.setNumber(5);
        song15.setAlbum(album1);
        song15.setName("Litania");

        Song song16 = new Song();
        song16.setDisc(1);
        song16.setNumber(6);
        song16.setAlbum(album1);
        song16.setName("Repetition");

        Song song17 = new Song();
        song17.setDisc(1);
        song17.setNumber(7);
        song17.setAlbum(album1);
        song17.setName("Ballad for Bernt");

        Song song18 = new Song();
        song18.setDisc(1);
        song18.setNumber(8);
        song18.setAlbum(album1);
        song18.setName("The Witch");

        List<Song> songs1 = new ArrayList<>();
        songs1.add(song11);
        songs1.add(song12);
        songs1.add(song13);
        songs1.add(song14);
        songs1.add(song15);
        songs1.add(song16);
        songs1.add(song17);
        songs1.add(song18);

        for (Song song : songs1)
            manager.persist(song);
        manager.flush();

        Song song21 = new Song();
        song21.setDisc(1);
        song21.setNumber(1);
        song21.setAlbum(album2);
        song21.setName("Luminol");

        Song song22 = new Song();
        song22.setDisc(1);
        song22.setNumber(2);
        song22.setAlbum(album2);
        song22.setName("Drive Home");

        Song song23 = new Song();
        song23.setDisc(1);
        song23.setNumber(3);
        song23.setAlbum(album2);
        song23.setName("The Holy Drinker");

        Song song24 = new Song();
        song24.setDisc(1);
        song24.setNumber(4);
        song24.setAlbum(album2);
        song24.setName("The Pin Drop");

        Song song25 = new Song();
        song25.setDisc(1);
        song25.setNumber(5);
        song25.setAlbum(album2);
        song25.setName("The Watchmaker");

        Song song26 = new Song();
        song26.setDisc(1);
        song26.setNumber(6);
        song26.setAlbum(album2);
        song26.setName("The Raven That Refused to Sing");

        List<Song> songs2 = new ArrayList<>();
        songs2.add(song21);
        songs2.add(song22);
        songs2.add(song23);
        songs2.add(song24);
        songs2.add(song25);
        songs2.add(song26);

        for (Song song : songs2)
            manager.persist(song);
        manager.flush();

        try {
            Queries queries = new Queries(manager);
            Writer<Album> albumWriter = new Writer<Album>();
            List<Album> result1 = queries.getAlbumsFromArtist(artist3);
            albumWriter.serializeList("json/results/query1.json", result1);

            Writer<Song> songWriter = new Writer<Song>();
            List<Song> result2 = queries.getSongsOnAlbum(album1);
            songWriter.serializeList("json/results/query2.json", result2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
