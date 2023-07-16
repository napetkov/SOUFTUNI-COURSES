import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.InputStream;

public class UnmarshallMain {
    public static void main(String[] args) throws JAXBException {

//        JAXBContext jaxbContext = JAXBContext.newInstance(AddressDTO.class);
//        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//
//        AddressDTO addressDTO = (AddressDTO) unmarshaller.unmarshal(System.in);
//
//        System.out.println(addressDTO);

        JAXBContext jaxbListContext = JAXBContext.newInstance(AddressesDTO.class);
        Unmarshaller listUnmarshaller = jaxbListContext.createUnmarshaller();

//        AddressesDTO addressesDTO = (AddressesDTO) listUnmarshaller.unmarshal(System.in);
//        System.out.println(addressesDTO);

        InputStream resourceAsStream = UnmarshallMain.class.getResourceAsStream("new.xml");

        AddressesDTO fromFile = (AddressesDTO) listUnmarshaller.unmarshal(resourceAsStream);
        System.out.println(fromFile);


    }
}
