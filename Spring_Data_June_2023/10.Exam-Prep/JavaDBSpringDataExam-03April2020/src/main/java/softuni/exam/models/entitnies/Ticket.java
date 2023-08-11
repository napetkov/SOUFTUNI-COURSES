package softuni.exam.models.entitnies;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket extends BaseEntity{

    @Column(name = "serial_number",unique = true)
    private String serialNumber;

    @Column
    private BigDecimal price;

    @Column(name = "take_off",columnDefinition = "DATETIME")
    private LocalDateTime takeoff;

    @ManyToOne
    @JoinColumn(name = "from_town_id")
    private Town fromTown;

    @ManyToOne
    @JoinColumn(name = "to_town_id")
    private Town toTown;

    @ManyToOne
    private Passenger passenger;

    @ManyToOne
    private Plane plane;

    public Ticket() {
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getTakeoff() {
        return takeoff;
    }

    public void setTakeoff(LocalDateTime takeoff) {
        this.takeoff = takeoff;
    }

    public Town getFromTown() {
        return fromTown;
    }

    public void setFromTown(Town fromTown) {
        this.fromTown = fromTown;
    }

    public Town getToTown() {
        return toTown;
    }

    public void setToTown(Town toTown) {
        this.toTown = toTown;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }
}
