package ForLoops.MoreExercises;

import java.util.Scanner;

public class BackToThePast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double xMoney = Double.parseDouble(scanner.nextLine());
        int lastYear = Integer.parseInt(scanner.nextLine());
        double sumEven = 0;
        double sumOdd = 0;
        double totalSum = 0;
        for (int i = 1800; i <= lastYear; i++) {
            if (i % 2 == 0) {
                sumEven += 12000;

            } else {
                sumOdd += (12000 + 50 * (i + 18 - 1800));
            }
        }
        totalSum = sumEven + sumOdd;

        if (totalSum <= xMoney) {
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", xMoney - totalSum);
        } else {
            System.out.printf("He will need %.2f dollars to survive.", totalSum - xMoney);
        }
    }
}
