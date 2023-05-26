package Vehicles;

import org.w3c.dom.ls.LSOutput;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
    public static final double AC_ADDITIONAL_CONSUMPTION = 1.6;
    public static final double FUEL_AFTER_DRIVER_DEDUCTION = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption,double tankCapacity) {
        super(fuelQuantity, fuelConsumption + AC_ADDITIONAL_CONSUMPTION,tankCapacity);
    }


    @Override
    public void refuel(double litters) {
        super.refuel(litters * FUEL_AFTER_DRIVER_DEDUCTION);

    }
}
