package NestedLoops.MoreExercises;

import java.util.Scanner;

public class SecretDoorsLock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hundreds = Integer.parseInt(scanner.nextLine());
        int tens = Integer.parseInt(scanner.nextLine());
        int units = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= hundreds; i++) {
            boolean isEvenHundreds = false;
            if (i % 2 == 0) {
                isEvenHundreds = true;
            }

            for (int j = 2; j <= tens; j++) {
                boolean isPrime = true;
                for (int k = 2; k <= j-1; k++) {
                    if (j % k == 0) {
                        isPrime = false;
                    }

                }
                for (int l = 1; l <= units; l++) {
                    boolean isEvenUnits = false;
                    if (l % 2 == 0) {
                        isEvenUnits = true;
                    }
                    if (isEvenHundreds && isEvenUnits && isPrime) {
                        System.out.printf("%d %d %d%n", i, j, l);
                    }
                }

            }

        }


    }
}
