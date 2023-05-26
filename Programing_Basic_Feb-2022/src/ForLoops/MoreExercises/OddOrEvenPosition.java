package ForLoops.MoreExercises;

import java.util.Scanner;

public class OddOrEvenPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double oddSum = 0;
        double oddMin = Integer.MAX_VALUE;
        double oddMax = Integer.MIN_VALUE;
        double evenSum = 0;
        double evenMin = Integer.MAX_VALUE;
        double evenMax = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            double number = Double.parseDouble(scanner.nextLine());
            if (i % 2 == 0) {
                evenSum += number;
                if (evenMin > number) {
                    evenMin = number;
                }
                if (evenMax < number) {
                    evenMax = number;
                }
            } else {
                oddSum += number;
                if (oddMin > number) {
                    oddMin = number;
                }
                if (oddMax < number) {
                    oddMax = number;
                }
            }

        }
        System.out.printf("OddSum=%.2f,%n", oddSum);
        if (oddMin == Integer.MAX_VALUE) {
            System.out.printf("OddMin=No,%n");
        } else {
            System.out.printf("OddMin=%.2f,%n", oddMin);
        }
        if (oddMax == Integer.MIN_VALUE) {
            System.out.printf("OddMax=No,%n");
        } else {
            System.out.printf("OddMax=%.2f,%n", oddMax);
        }
        System.out.printf("EvenSum=%.2f,%n", evenSum);
        if (evenMin == Integer.MAX_VALUE) {
            System.out.printf("EvenMin=No,%n");
        } else {
            System.out.printf("EvenMin=%.2f,%n", evenMin);
        }
        if (evenMax == Integer.MIN_VALUE) {
            System.out.printf("EvenMax=No%n");
        } else {
            System.out.printf("EvenMax=%.2f", evenMax);
        }

    }
}
