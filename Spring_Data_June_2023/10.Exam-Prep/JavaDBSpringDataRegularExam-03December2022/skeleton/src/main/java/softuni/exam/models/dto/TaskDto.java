package softuni.exam.models.dto;

import java.math.BigDecimal;
import java.util.Locale;

public class TaskDto {

    private Long id;

    private BigDecimal price;

    private MechanicBasicInfoDto mechanic;

    private CarBasicDto car;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public MechanicBasicInfoDto getMechanic() {
        return mechanic;
    }

    public void setMechanic(MechanicBasicInfoDto mechanic) {
        this.mechanic = mechanic;
    }

    public CarBasicDto getCar() {
        return car;
    }

    public void setCar(CarBasicDto car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "Car %s %s with %dkm\n-Mechanic: %s %s - task №%d:\n --Engine: %.1f\n---Price: %.2f$",
                this.car.getCarMake(),
                this.car.getCarModel(),
                this.car.getKilometers(),
                this.mechanic.getFirstName(),
                this.mechanic.getLastName(),
                this.getId(),
                this.car.getEngine(),
                this.getPrice());
    }


}
