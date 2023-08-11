package softuni.exam.models.dtos;

import softuni.exam.models.entitnies.Town;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.time.LocalDate;

@XmlRootElement(name = "ticket")
@XmlAccessorType(XmlAccessType.FIELD)
public class TicketImportDto {
    @XmlElement(name = "serial-number")
    @Size(min = 2)
    private String serialNumber;

    @XmlElement
    @Positive
    private BigDecimal price;

    @XmlElement(name = "take-off")
    private String takeoff;

    @XmlElement(name = "from-town")
    private FromTown fromTown;

    @XmlElement(name = "to-town")
    private ToTown toTown;

    @XmlElement
    private BasePassenger passenger;

    private BasePlane plane;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public BasePassenger getPassenger() {
        return passenger;
    }

    public void setPassenger(BasePassenger passenger) {
        this.passenger = passenger;
    }

    public BasePlane getPlane() {
        return plane;
    }

    public void setPlane(BasePlane plane) {
        this.plane = plane;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTakeoff() {
        return takeoff;
    }

    public void setTakeoff(String takeoff) {
        this.takeoff = takeoff;
    }

    public FromTown getFromTown() {
        return fromTown;
    }

    public void setFromTown(FromTown fromTown) {
        this.fromTown = fromTown;
    }

    public ToTown getToTown() {
        return toTown;
    }

    public void setToTown(ToTown toTown) {
        this.toTown = toTown;
    }
}
