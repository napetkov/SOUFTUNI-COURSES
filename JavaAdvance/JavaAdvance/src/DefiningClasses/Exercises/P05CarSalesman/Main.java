package DefiningClasses.Exercises.P05CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersOfEngine = Integer.parseInt(scanner.nextLine());

        List<Engine> typeOfEngine = new ArrayList<>();

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < numbersOfEngine; i++) {
            String[] dataEngine = scanner.nextLine().split("\\s+");
            String engineModel = dataEngine[0];
            String enginePower = dataEngine[1];
            Engine engine = new Engine(engineModel, enginePower);

            switch (dataEngine.length) {
                case 3:
                    String displacementOrEfficiency = dataEngine[2];
                    if (Character.isDigit(dataEngine[2].charAt(0))) {
                        engine = new Engine(engineModel, enginePower, displacementOrEfficiency, "n/a");
                    } else {
                        engine = new Engine(engineModel, enginePower, "n/a", displacementOrEfficiency);
                    }
                    break;
                case 4:
                    String engineDisplacement = dataEngine[2];
                    String engineEfficiency = dataEngine[3];
                    engine = new Engine(engineModel, enginePower, engineDisplacement, engineEfficiency);
                    break;
            }

            typeOfEngine.add(engine);
        }

        int numbersOfCars = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numbersOfCars; i++) {
            String[] dataCar = scanner.nextLine().split("\\s+");
            String carModel = dataCar[0];
            String enginModel = dataCar[1];
            Engine engine = typeOfEngine.stream()
                    .filter(e-> e.getModel().equals(enginModel))
                    .findFirst().get();

            Car car = new Car(carModel,engine);

            switch (dataCar.length){
                case 3:
                if(Character.isDigit(dataCar[2].charAt(0))){
                    car = new Car(carModel,engine,dataCar[2],"n/a");
                }else{
                    car = new Car(carModel,engine,"n/a",dataCar[2]);
                }
                    break;
                case 4:
                    String weight = dataCar[2];
                    String color = dataCar[3];
                    car = new Car(carModel,engine,weight,color);
                    break;
            }

            cars.add(car);

        }

        cars.forEach(System.out::print);
    }
}
