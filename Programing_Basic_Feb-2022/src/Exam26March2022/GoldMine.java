package Exam26March2022;

import java.util.Scanner;

public class GoldMine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int locations = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < locations; i++) {
            double average = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            double sumGoldPerDay = 0;
            for (int j = 0; j < days; j++) {
                double minedGold = Double.parseDouble(scanner.nextLine());
                sumGoldPerDay += minedGold;
            }
            sumGoldPerDay = sumGoldPerDay/days;
            if (sumGoldPerDay >= average) {
                System.out.printf("Good job! Average gold per day: %.2f.%n", sumGoldPerDay);
            } else {
                System.out.printf("You need %.2f gold.%n", average - sumGoldPerDay);
            }


        }
    }
}
