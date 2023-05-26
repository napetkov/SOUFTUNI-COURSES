package DefiningClasses.Lab.P02Constructors;

public class Car {
    private String brand;
    private String model;
    private int horsePower;


    public void setBrand(String brand){
        this.brand = brand;
    }

    public void setModel(String model){
        this.model = model;
    }
    public void setHorsePower(int horsePower){
        this.horsePower = horsePower;
    }

    public Car(String brand,String model,int horsePower){
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public Car(String brand){
        this(brand,"unknown",-1);
    }
    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.",brand,model,horsePower);
    }
}
