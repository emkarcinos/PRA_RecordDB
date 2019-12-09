package JSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class Writer<T> {

    public void serializeList(String filepath, List<T> objects) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.registerModule(new JodaModule());

        File file = new File(filepath);
        for (T obj : objects){
            objectMapper.writeValue(file, obj);
        }
    }

    public static void serialize(String filepath, Serializable object) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        File file = new File(filepath);
        objectMapper.writeValue(file, object);
    }
}
