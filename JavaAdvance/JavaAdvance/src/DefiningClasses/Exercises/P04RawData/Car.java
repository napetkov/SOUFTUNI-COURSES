package DefiningClasses.Exercises.P04RawData;

import java.util.List;
import java.util.stream.Collectors;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire tires;

    public Car(String model, Engine engine, Cargo cargo, Tire tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    static boolean isCargoFragile(String searchCargoType) {
        return searchCargoType.equals("fragile");
    }

    static List<Car> getCarsOfTypeCargo(String searchCargoType, List<Car> cars) {
        return cars.stream()
                .filter(e -> e.getCargo().getCargoType().equals(searchCargoType))
                .collect(Collectors.toList());

    }

    public void printCar(Car car, String searchCargoType) {
        if (isCargoFragile(searchCargoType)) {
            List<Double> pressure = car.getTires().getTirePressure();

            if (enoughPressure(pressure)) {
                System.out.println(car.getModel());
            }
    } else{
            if (car.getEngine().getEnginePower() > 250) {
                System.out.println(car.getModel());
            }
        }
    }

    public boolean enoughPressure(List<Double> pressure) {
        boolean flag = false;
        for (Double pre : pressure) {
            if (pre < 1) {
                flag = true;
                break;
            } else {
                flag =  false;
            }
        }
        return flag;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Tire getTires() {
        return tires;
    }

    public void setTires(Tire tires) {
        this.tires = tires;
    }
}
