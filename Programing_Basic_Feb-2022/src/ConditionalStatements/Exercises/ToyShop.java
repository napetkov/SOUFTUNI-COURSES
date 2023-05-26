package ConditionalStatements.Exercises;

import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double excursion = Double.parseDouble(scanner.nextLine());

        int puzzles = Integer.parseInt(scanner.nextLine());
        int dolls = Integer.parseInt(scanner.nextLine());
        int teddyBears = Integer.parseInt(scanner.nextLine());
        int minions = Integer.parseInt(scanner.nextLine());
        int trucks = Integer.parseInt(scanner.nextLine());

//        double puzzlesPrice = puzzles * 2.60;
//        double dollsPrice = dolls * 3.00;
//        double teddyBearsPrice = teddyBears * 4.10;
//        double minionsPrice = minions * 8.20;
//        double truckPrice = trucks * 2.00;

        int allCounts = puzzles + dolls + teddyBears + minions + trucks;
        double allPrice = (puzzles * 2.60) + (dolls * 3.00) + (teddyBears * 4.10) + (minions * 8.20) + (trucks * 2.00);

        if (allCounts >= 50) {
            allPrice = allPrice - allPrice * 0.25;
        }
        allPrice = allPrice - allPrice * 0.1;
        double result = Math.abs(allPrice - excursion);

        if (allPrice >= excursion) {
            System.out.printf("Yes! %.2f lv left.", result);

        } else {
            System.out.printf("Not enough money! %.2f lv needed.", result);
        }

    }

}
