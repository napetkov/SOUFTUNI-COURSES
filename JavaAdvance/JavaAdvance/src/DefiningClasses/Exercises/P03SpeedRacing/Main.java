package DefiningClasses.Exercises.P03SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersOfCars = Integer.parseInt(scanner.nextLine());

        Set<Car> cars = new LinkedHashSet<>();

        for (int i = 0; i < numbersOfCars; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String carModel = data[0];
            double fuelAmount = Integer.parseInt(data[1]);
            double fuelCostFor1km = Double.parseDouble(data[2]);

            Car car = new Car(carModel, fuelAmount, fuelCostFor1km);
            cars.add(car);
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] dataDrive = input.split(" ");
            String currentCarModel = dataDrive[1];
            int distance = Integer.parseInt(dataDrive[2]);

            Car currentCar = cars.stream()
                    .filter(car -> car.getCarModel().equals(currentCarModel))
                    .findFirst()
                    .get();

            if(currentCar.isEnoughFuel(distance)){
                cars.stream()
                        .filter(car -> car.getCarModel().equals(currentCarModel))
                        .findFirst()
                        .get()
                        .carTravel(distance);
            }else{
                System.out.println("Insufficient fuel for the drive");
            }

            input = scanner.nextLine();
        }

        cars.forEach(System.out::println);
    }
}
