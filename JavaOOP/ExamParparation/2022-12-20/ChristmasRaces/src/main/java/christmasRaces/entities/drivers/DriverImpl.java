package christmasRaces.entities.drivers;

import christmasRaces.entities.cars.Car;

import static christmasRaces.common.ExceptionMessages.CAR_INVALID;
import static christmasRaces.common.ExceptionMessages.INVALID_NAME;

public class DriverImpl implements Driver {
    private String name;
    private Car car;
    private int numberOfWins;
    private boolean canParticipate;
    private static final int MAX_LENGTH_OF_SYMBOLS = 5;
    public DriverImpl(String name) {
        this.setName(name);
    }

    public void setName(String name) {

        if (name == null || name.trim().isEmpty() || name.length() < MAX_LENGTH_OF_SYMBOLS) {
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, MAX_LENGTH_OF_SYMBOLS));
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Car getCar() {
        return car;
    }

    @Override
    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException(CAR_INVALID);
        }
        this.car = car;
    }


    @Override
    public void addCar(Car car) {
        setCar(car);
    }

    @Override
    public void winRace() {
        numberOfWins++;
    }

    @Override
    public boolean getCanParticipate() {
        if (getCar() != null) {
            return true;
        }
        return false;
    }
}
