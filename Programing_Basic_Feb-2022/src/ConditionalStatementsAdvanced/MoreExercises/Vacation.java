package ConditionalStatementsAdvanced.MoreExercises;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        double vacationBudget = 0;
        String location = "";
        String vacationBook = "";

        if (budget <= 1000) {
            vacationBook = "Camp";
            switch (season) {
                case "Summer":
                    location = "Alaska";
                    vacationBudget = budget * 0.65;
                    break;
                case "Winter":
                    location = "Morocco";
                    vacationBudget = budget * 0.45;
                    break;
            }
        } else if (budget <= 3000) {
            vacationBook = "Hut";
            switch (season) {
                case "Summer":
                    location = "Alaska";
                    vacationBudget = budget * 0.80;
                    break;
                case "Winter":
                    location = "Morocco";
                    vacationBudget = budget * 0.60;
                    break;
            }

        } else if (budget > 500) {
            vacationBook = "Hotel";
            vacationBudget = budget * 0.90;
            switch (season) {
                case "Summer":
                    location = "Alaska";
                    break;
                case "Winter":
                    location = "Morocco";

                    break;
            }

        }

        System.out.printf("%s - %s - %.2f", location, vacationBook, vacationBudget);
    }
}
