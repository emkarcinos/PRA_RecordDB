package Parser;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class XmlWriter<T> {
    public void serializeList(String filepath, List<T> objects) throws IOException {
        XmlMapper objectMapper = new XmlMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.registerModule(new JodaModule());
        objectMapper.writeValue(new File(filepath), objects);
    }

    public void serialize(String filepath, T object) throws IOException {
        XmlMapper objectMapper = new XmlMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.writeValue(new File(filepath), object);
    }
}
