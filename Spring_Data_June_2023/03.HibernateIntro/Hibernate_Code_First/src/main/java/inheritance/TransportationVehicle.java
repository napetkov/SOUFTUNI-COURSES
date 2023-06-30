package inheritance;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class TransportationVehicle extends Vehicle {

    @Column(name = "num_of_containers")
    private int numOfContainers;

    public TransportationVehicle() {
    }

    public TransportationVehicle(int numOfContainers) {
        this.numOfContainers = numOfContainers;
    }

    public int getNumOfContainers() {
        return numOfContainers;
    }

    public void setNumOfContainers(int numOfContainers) {
        this.numOfContainers = numOfContainers;
    }
}
