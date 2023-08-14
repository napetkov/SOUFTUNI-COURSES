package softuni.exam.util;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Component
public class XmlParser {

    public <T> T fromFile(String filePath , Class<T> object) throws JAXBException {
        final JAXBContext context = JAXBContext.newInstance(object);
        final Unmarshaller unmarshaller = context.createUnmarshaller();

//        final FileReader fileReader = new FileReader(file);

        return (T) unmarshaller.unmarshal(new File(filePath));
    }
}