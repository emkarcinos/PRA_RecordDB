package JSON;

import Database.Model.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Reader {

    public static List<Artist> createArtistsFromJson(String jsonPath){
        ObjectMapper mapper = new ObjectMapper();
        List<Artist> artists = null;
        try {
            artists = mapper.reader().forType(new TypeReference<List<Artist>>(){}).readValue(new File(jsonPath));
        } catch (IOException e){
            e.printStackTrace();
        }
        return artists;
    }

    public static List<Album> createAlbumsFromJson(String jsonPath){
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JodaModule());
        List<Album> albums = null;
        try {
            albums = mapper.reader().forType(new TypeReference<List<Album>>(){}).readValue(new File(jsonPath));
        } catch (IOException e){
            e.printStackTrace();
        }
        return albums;
    }

    public static List<Genre> createGenresFromJson(String jsonPath){
        ObjectMapper mapper = new ObjectMapper();
        List<Genre> genres = null;
        try {
            genres = mapper.reader().forType(new TypeReference<List<Genre>>(){}).readValue(new File(jsonPath));
        } catch (IOException e){
            e.printStackTrace();
        }
        return genres;
    }

    public static List<Label> createLabelsFromJson(String jsonPath){
        ObjectMapper mapper = new ObjectMapper();
        List<Label> labels = null;
        try {
            labels = mapper.reader().forType(new TypeReference<List<Label>>(){}).readValue(new File(jsonPath));
        } catch (IOException e){
            e.printStackTrace();
        }
        return labels;
    }

    public static List<AlbumType> createTypesFromJson(String jsonPath){
        ObjectMapper mapper = new ObjectMapper();
        List<AlbumType> types = null;
        try {
            types = mapper.reader().forType(new TypeReference<List<AlbumType>>(){}).readValue(new File(jsonPath));
        } catch (IOException e){
            e.printStackTrace();
        }
        return types;
    }

}
