package christmasRaces.entities.races;

import christmasRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;

import static christmasRaces.common.ExceptionMessages.*;

public class RaceImpl implements Race {
    private String name;
    private int laps;
    private Collection<Driver> drivers;
    private static final int MIN_LENGTH_OF_SYMBOLS = 5;
    private static final int MIN_LAPS = 1;

    public RaceImpl(String name, int laps) {
        this.name = name;
        this.laps = laps;
        drivers = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < MIN_LENGTH_OF_SYMBOLS) {
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, MIN_LENGTH_OF_SYMBOLS));
        }
        this.name = name;
    }

    public void setLaps(int laps) {
        if (laps < 1){
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_LAPS,MIN_LAPS));
        }
            this.laps = laps;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLaps() {
        return laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return drivers;
    }

    @Override
    public void addDriver(Driver driver) {
        if(driver == null){
            throw new IllegalArgumentException(DRIVER_INVALID);
        }

        if(!driver.getCanParticipate()){
            throw new IllegalArgumentException(String.format(DRIVER_NOT_PARTICIPATE,driver.getName()));
        }

        if(drivers.contains(driver)){
            throw new IllegalArgumentException(String.format(DRIVER_ALREADY_ADDED,driver.getName(),getName()));
        }

        drivers.add(driver);

    }
}
