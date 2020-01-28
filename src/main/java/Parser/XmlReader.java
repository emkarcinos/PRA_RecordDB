package Parser;

import Database.Model.ContactInfo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlReader {
    public static List<ContactInfo> createContactInfosFromXml(String xmlpath) {
        XmlMapper mapper = new XmlMapper();
        List<ContactInfo> contacts = new ArrayList<>();
        try {
            contacts = mapper.reader().forType(new TypeReference<List<ContactInfo>>() {
            }).readValue(new File(xmlpath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contacts;
    }
}
