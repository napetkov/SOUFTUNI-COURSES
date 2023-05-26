package ConditionalStatementsAdvanced.MoreExercises;

import java.util.Scanner;

public class Flowers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int chrysanthemums = Integer.parseInt(scanner.nextLine());
        int roses = Integer.parseInt(scanner.nextLine());
        int tulips = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        String isHoliday = scanner.nextLine();

        double chrysanthemumsPrice = 0;
        double rosesPrice = 0;
        double tulipsPrice = 0;

        switch (season) {
            case "Spring":
            case "Summer":
                chrysanthemumsPrice = 2.00;
                rosesPrice = 4.10;
                tulipsPrice = 2.50;
                break;
            case "Autumn":
            case "Winter":
                chrysanthemumsPrice = 3.75;
                rosesPrice = 4.50;
                tulipsPrice = 4.15;
                break;

        }
        double totalPrice = chrysanthemumsPrice * chrysanthemums + rosesPrice * roses + tulipsPrice * tulips;
        if (isHoliday.equals("Y")) {
            totalPrice = totalPrice * 1.15;
            if (tulips > 7 && season.equals("Spring")) {
                totalPrice = totalPrice - totalPrice * 0.05;
            }
            if (roses >= 10 && season.equals("Winter")) {
                totalPrice = totalPrice - totalPrice * 0.10;
            }
            if ((chrysanthemums + roses + tulips) > 20) {
                totalPrice = totalPrice - totalPrice * 0.20;
            }

        } else if (isHoliday.equals("N")) {
            if (tulips > 7 && season.equals("Spring")) {
                totalPrice = totalPrice - totalPrice * 0.05;
            }
            if (roses >= 10 && season.equals("Winter")) {
                totalPrice = totalPrice - totalPrice * 0.10;
            }
            if ((chrysanthemums + roses + tulips) > 20) {
                totalPrice = totalPrice - totalPrice * 0.20;
            }
        }
        System.out.printf("%.2f",(totalPrice+2));

    }
}
