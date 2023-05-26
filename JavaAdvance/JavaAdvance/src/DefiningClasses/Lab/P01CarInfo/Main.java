package DefiningClasses.Lab.P01CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Car[] carList = new Car[n];

        for (int i = 0; i < n; i++) {
            carList[i] = new Car();

            String input[] = scanner.nextLine().split("\\s+");

            carList[i].setBrand(input[0]);
            carList[i].setModel(input[1]);
            carList[i].setHorsePower(Integer.parseInt(input[2]));

             }
        for (Car car : carList) {
            System.out.println(car.toString());
        }


    }
}
