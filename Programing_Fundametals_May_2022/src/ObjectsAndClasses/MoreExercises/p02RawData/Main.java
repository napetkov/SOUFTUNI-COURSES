package ObjectsAndClasses.MoreExercises.p02RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Engine> listOfEngine = new ArrayList<>();
        List<Cargo> listOfCargo = new ArrayList<>();
        List<Tire> listOfTire = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] inputArr = scanner.nextLine().split(" ");

            String inputModel = inputArr[0];
            int inputEngineSpeed = Integer.parseInt(inputArr[1]);
            int inputEnginePower = Integer.parseInt(inputArr[2]);

            Engine currentEngine = new Engine(inputModel, inputEngineSpeed, inputEnginePower);
            listOfEngine.add(currentEngine);

            int inputCargoWeight = Integer.parseInt(inputArr[3]);
            String inputCargoType = inputArr[4];

            Cargo currentCargo = new Cargo(inputModel, inputCargoWeight, inputCargoType);
            listOfCargo.add(currentCargo);

            double inputTire1Pressure = Double.parseDouble(inputArr[5]);
            int inputTire1Age = Integer.parseInt(inputArr[6]);
            double inputTire2Pressure = Double.parseDouble(inputArr[7]);
            int inputTire2Age = Integer.parseInt(inputArr[8]);
            double inputTire3Pressure = Double.parseDouble(inputArr[9]);
            int inputTire3Age = Integer.parseInt(inputArr[10]);
            double inputTire4Pressure = Double.parseDouble(inputArr[11]);
            int inputTire4Age = Integer.parseInt(inputArr[12]);

            Tire currentTire = new Tire(inputModel, inputTire1Pressure, inputTire1Age, inputTire2Pressure, inputTire2Age, inputTire3Pressure,
                    inputTire3Age, inputTire4Pressure, inputTire4Age);
            listOfTire.add(currentTire);


        }

        String command = scanner.nextLine();

        if (command.equals("fragile")) {

            for (Tire tire : listOfTire) {
                if (tire.getTire1Pressure() < 1 || tire.getTire2Pressure() < 1 || tire.getTire3Pressure() < 1 || tire.getTire4Pressure() < 1) {
                    System.out.println(tire.getModel());
                }
            }


        } else if (command.equals("flamable")) {

            for (Engine power : listOfEngine) {
                if (power.getEnginePower() > 250) {
                    System.out.println(power.getModel().toString());
                }
            }


        }


    }
}
