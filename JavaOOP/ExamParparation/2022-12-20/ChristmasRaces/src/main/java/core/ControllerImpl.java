package core;

import core.interfaces.Controller;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;
import christmasRaces.entities.races.RaceImpl;
import christmasRaces.repositories.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static christmasRaces.common.ExceptionMessages.*;
import static christmasRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String name) {
        Driver driver = driverRepository.getByName(name);

        if (driver != null) {
            throw new IllegalArgumentException(String.format(DRIVER_EXISTS, name));
        }
        driver = new DriverImpl(name);
        driverRepository.add(driver);

        return String.format(DRIVER_CREATED, name);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car;

        switch (type) {
            case "Muscle":
                car = new MuscleCar(model, horsePower);
                break;
            case "Sports":
                car = new SportsCar(model, horsePower);
                break;
            default:
                car = null;
        }
        if (carRepository.getAll().contains(car)) {
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        }
        carRepository.add(car);

        return String.format(CAR_CREATED, type, model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driver = getDriverByName(driverName);

        Car car = carRepository.getByName(carModel);
        if (car == null) {
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));
        }

        driver.addCar(car);
        return String.format(CAR_ADDED, driverName, carModel);
    }

    private Driver getDriverByName(String driverName) {
        Driver driver = driverRepository.getByName(driverName);
        if (driver == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }
        return driver;
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race race = raceRepository.getByName(raceName);
        if (race == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        Driver driver = getDriverByName(driverName);

        race.addDriver(driver);

        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = raceRepository.getByName(raceName);
        if (race == null){
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND,raceName));
        }
        if(race.getDrivers().size() < 3){
            throw new IllegalArgumentException(String.format(RACE_INVALID,raceName,3));
        }

        List<Driver> sortedDrivers = race.getDrivers().stream()
                .sorted((d1, d2) -> Double.compare(d2.getCar().calculateRacePoints(race.getLaps())
                        , d1.getCar().calculateRacePoints(race.getLaps())))
                .collect(Collectors.toList());
        sortedDrivers.get(0).winRace();

        raceRepository.remove(race);
        StringBuilder out = new StringBuilder();
        out.append(String.format(DRIVER_FIRST_POSITION,sortedDrivers.get(0).getName(),raceName))
                        .append(System.lineSeparator());
        out.append(String.format(DRIVER_SECOND_POSITION,sortedDrivers.get(1).getName(),raceName))
                .append(System.lineSeparator());
        out.append(String.format(DRIVER_THIRD_POSITION,sortedDrivers.get(2).getName(),raceName));

        return out.toString().trim();
    }

    @Override
    public String createRace(String name, int laps) {
        Race race = raceRepository.getByName(name);
        if (race != null) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }
        race = new RaceImpl(name, laps);

        raceRepository.add(race);

        return String.format(RACE_CREATED, name);
    }
}
