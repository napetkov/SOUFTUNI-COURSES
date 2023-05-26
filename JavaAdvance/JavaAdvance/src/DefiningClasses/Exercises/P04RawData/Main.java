package DefiningClasses.Exercises.P04RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersOfCars = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();


        for (int i = 0; i < numbersOfCars; i++) {
            List<Double> tirePressure = new ArrayList<>();
            List<Integer> tireAge = new ArrayList<>();
            String[] data = scanner.nextLine().split("\\s+");
            String carModel = data[0];
            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);
            String cargoWeight = data[3];
            String cargoType = data[4];
            for (int j = 5; j < data.length; j=j+2) {
                double currentTirePressure = Double.parseDouble(data[j]);
                tirePressure.add(currentTirePressure);
            }
            for (int j = 6; j < data.length; j=j+2) {
                int currentTireAge = Integer.parseInt(data[j]);
                tireAge.add(currentTireAge);
            }

            Engine engine = new Engine(engineSpeed,enginePower);
            Cargo cargo = new Cargo(cargoWeight,cargoType);
            Tire tire = new Tire(tirePressure,tireAge);
            Car car = new Car(carModel,engine,cargo,tire);

            cars.add(car);

        }

        String searchCargoType = scanner.nextLine().toLowerCase();

        List<Car> findCars =Car.getCarsOfTypeCargo(searchCargoType,cars);
        findCars.forEach(car -> car.printCar(car,searchCargoType));

        System.out.println();



    }
}
