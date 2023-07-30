package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Set;

@XmlRootElement(name = "astronomers")
@XmlAccessorType(XmlAccessType.FIELD)
public class AstronomersImportWrapperDto {

    @NotNull
    @XmlElement(name = "astronomer")
    List<AstronomersImportDto> astronomers;

    public List<AstronomersImportDto> getAstronomers() {
        return astronomers;
    }

    public void setAstronomers(List<AstronomersImportDto> astronomers) {
        this.astronomers = astronomers;
    }
}
