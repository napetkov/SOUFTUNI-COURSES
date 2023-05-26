package DefiningClasses.Lab.P01CarInfo;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.",brand,model,horsePower);
    }
}
