package ObjectsAndClasses.Exercises.p06vehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<VehicleCatalogue> vehicleList = new ArrayList<>();
        while (!input.equals("End")) {
            String inputType = input.split(" ")[0];
            String inputModel = input.split(" ")[1];
            String inputColor = input.split(" ")[2];
            int inputHorsePower = Integer.parseInt(input.split(" ")[3]);

            VehicleCatalogue currentVehicle = new VehicleCatalogue(inputType, inputModel, inputColor, inputHorsePower);

            vehicleList.add(currentVehicle);

            input = scanner.nextLine();
        }


        String command = scanner.nextLine();
        int countCars = 0;
        int countTrucks = 0;
        int sumHpCars = 0;
        int sumHpTrucks = 0;

        while (!command.equals("Close the Catalogue")) {
            for (VehicleCatalogue element : vehicleList) {
                if (element.getModel().equals(command)) {
                    System.out.println(element.toString());
                }
            }

            command = scanner.nextLine();
        }
        for (VehicleCatalogue element : vehicleList) {
            if (element.getType().equals("car")) {
                countCars++;
                sumHpCars += element.getHorsePower();

            } else if (element.getType().equals("truck")) {
                countTrucks++;
                sumHpTrucks += element.getHorsePower();

            }
        }
        double averageHpCars = 0;
        if (countCars != 0) {
            averageHpCars = sumHpCars * 1.00 / countCars;
        }

        double averageHpTruck = 0;
        if (countTrucks != 0) {
            averageHpTruck = sumHpTrucks * 1.00 / countTrucks;
        }

        System.out.printf("Cars have average horsepower of: %.2f.%n", averageHpCars);
        System.out.printf("Trucks have average horsepower of: %.2f.", averageHpTruck);


    }
}
