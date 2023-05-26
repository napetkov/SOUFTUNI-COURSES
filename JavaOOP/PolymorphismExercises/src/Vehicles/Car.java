package Vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle {
    public static double AC_ADDITIONAL_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption,double tankCapacity) {
        super(fuelQuantity, fuelConsumption+AC_ADDITIONAL_CONSUMPTION,tankCapacity);

    }



}
