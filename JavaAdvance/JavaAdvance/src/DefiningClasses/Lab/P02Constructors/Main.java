package DefiningClasses.Lab.P02Constructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] carData = scanner.nextLine().split("\\s+");

            Car car = carData.length == 1
                    ? new Car(carData[0])
                    : new Car(carData[0],carData[1],Integer.parseInt(carData[2]));

        cars.add(car);
        }

        for (Car car : cars) {
            System.out.println(car);
        }

    }
}
