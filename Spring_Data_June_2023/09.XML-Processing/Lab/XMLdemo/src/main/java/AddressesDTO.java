import jakarta.xml.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "addresses")
@XmlAccessorType(XmlAccessType.FIELD)

public class AddressesDTO implements Serializable {

    @XmlElementWrapper(name = "wrap")
    @XmlElement(name = "inner")
    private List<AddressDTO> addresses;

    @XmlElement(name = "main")
    private AddressDTO mainAddress;

    public AddressesDTO() {
    }

    public AddressesDTO(List<AddressDTO> addresses,AddressDTO mainAddress) {
        this.addresses = addresses;
        this.mainAddress = mainAddress;
    }

    @Override
    public String toString() {
        return "AddressesDTO{" +
                "addresses=" + addresses +
                ", mainAddress=" + mainAddress +
                '}';
    }
}
