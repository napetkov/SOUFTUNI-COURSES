package NestedLoops.MoreExercises;

import java.util.Scanner;

public class HappyCatParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int hours = Integer.parseInt(scanner.nextLine());
        double totalTax = 0;
        for (int i = 1; i <= days; i++) {
            double taxForDay = 0;
            for (int j = 1; j <= hours; j++) {
                double taxForHour = 1;
                if (i % 2 == 0 && j % 2 != 0) {
                    taxForHour = 2.50;
                } else if (i % 2 != 0 && j % 2 == 0) {
                    taxForHour = 1.25;
                }
                taxForDay += taxForHour;
            }
            totalTax+=taxForDay;

            System.out.printf("Day: %d - %.2f leva%n",i, taxForDay);
        }
        System.out.printf("Total: %.2f leva",totalTax);
    }
}
