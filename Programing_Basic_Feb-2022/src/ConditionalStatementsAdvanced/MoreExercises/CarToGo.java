package ConditionalStatementsAdvanced.MoreExercises;

import java.util.Scanner;

public class CarToGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        double budgetCar = 0;
        String carType = "";
        String carClass = "";

        if (budget <= 100) {
            carClass = "Economy class";
            switch (season) {
                case "Summer":
                    carType = "Cabrio";
                    budgetCar = budget * 0.35;
                    break;
                case "Winter":
                    carType = "Jeep";
                    budgetCar = budget * 0.65;
                    break;
            }

        } else if (budget <= 500) {
            carClass = "Compact class";
            switch (season) {
                case "Summer":
                    carType = "Cabrio";
                    budgetCar = budget * 0.45;
                    break;
                case "Winter":
                    carType = "Jeep";
                    budgetCar = budget * 0.80;
                    break;
            }

        } else if (budget > 500) {
            carClass = "Luxury class";
            carType = "Jeep";
            budgetCar = budget * 0.90;


        }

        System.out.println(carClass);
        System.out.printf("%s - %.2f",carType, budgetCar);
    }
}
