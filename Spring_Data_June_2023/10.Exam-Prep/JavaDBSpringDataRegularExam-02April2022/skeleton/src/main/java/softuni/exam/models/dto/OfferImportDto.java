package softuni.exam.models.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferImportDto {

    @NotNull
    @Positive
    @XmlElement
    private Double price;

    @NotNull
    @XmlElement
    private AgentFirstNameDto agent;

    @NotNull
    @XmlElement
    private ApartmentIdDto apartment;

    @NotNull
    @XmlElement(name = "publishedOn")
    private String publishedOn;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public AgentFirstNameDto getAgent() {
        return agent;
    }

    public void setAgent(AgentFirstNameDto agent) {
        this.agent = agent;
    }

    public ApartmentIdDto getApartment() {
        return apartment;
    }

    public void setApartment(ApartmentIdDto apartment) {
        this.apartment = apartment;
    }

    public String getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn;
    }
}
