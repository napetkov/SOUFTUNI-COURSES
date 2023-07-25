package softuni.exam.models.dto;

import softuni.exam.models.entity.ApartmentType;
import softuni.exam.models.entity.Town;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "apartment")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApartmentImportDto {
    @NotNull
    @XmlElement(name = "apartmentType")
    private String apartmentType;

    @NotNull
    @XmlElement(name = "area")
    @DecimalMin(value = "40.00")
    private Double area;

    @XmlElement(name = "town")
    @NotNull
    @Size(min = 2)
    private String town;

    public String getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(String apartmentType) {
        this.apartmentType = apartmentType;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
