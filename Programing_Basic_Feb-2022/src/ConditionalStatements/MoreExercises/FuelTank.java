package ConditionalStatements.MoreExercises;

import java.util.Scanner;

public class FuelTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String typeFuel = scanner.nextLine();
        int littersFuel = Integer.parseInt(scanner.nextLine());

        if (littersFuel >= 25) {
            if (typeFuel.equals("Diesel")) {
                System.out.printf("You have enough diesel.");
            } else if (typeFuel.equals("Gasoline")) {
                System.out.printf("You have enough gasoline.");
            } else if (typeFuel.equals("Gas")) {
                System.out.printf("You have enough gas.");
            } else {
                System.out.println("Invalid fuel!");
            }
        } else {
            if (typeFuel.equals("Diesel")) {
                System.out.printf("Fill your tank with diesel!");
            } else if (typeFuel.equals("Gasoline")) {
                System.out.printf("Fill your tank with gasoline!");
            } else if (typeFuel.equals("Gas")) {
                System.out.printf("Fill your tank with gas!");
            } else {
                System.out.println("Invalid fuel!");
            }

        }
    }
}