package ConditionalStatementsAdvanced.MoreExercises;

import java.util.Scanner;

public class TruckDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        double kmForMonth = Double.parseDouble(scanner.nextLine());
        double oneKmPrice = 0;

        if (kmForMonth <= 5000) {
            switch (season) {
                case "Spring":
                case "Autumn":
                    oneKmPrice = 0.75;
                    break;
                case "Summer":
                    oneKmPrice = 0.90;
                    break;
                case "Winter":
                    oneKmPrice = 1.05;
                    break;
            }
        } else if (kmForMonth <= 10000) {
            switch (season) {
                case "Spring":
                case "Autumn":
                    oneKmPrice = 0.95;
                    break;
                case "Summer":
                    oneKmPrice = 1.10;
                    break;
                case "Winter":
                    oneKmPrice = 1.25;
                    break;
            }
        } else if (kmForMonth <= 20000) {
            oneKmPrice = 1.45;
        }

        System.out.printf("%.2f", kmForMonth * 4 * oneKmPrice * 0.90);
    }
}
