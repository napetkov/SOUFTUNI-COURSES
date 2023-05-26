package NestedLoops.MoreExercises;

import java.util.Scanner;

public class PrimePairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startFirst = Integer.parseInt(scanner.nextLine());
        int startSecond = Integer.parseInt(scanner.nextLine());
        int diffFirst = Integer.parseInt(scanner.nextLine());
        int diffSecond = Integer.parseInt(scanner.nextLine());
        int endFirst = startFirst + diffFirst;
        int endSecond = startSecond + diffSecond;
        boolean isPrimeFirst = true;
        boolean isPrimeSecond = true;
        for (int i = startFirst; i <= endFirst; i++) {
            for (int k = startSecond; k <= endSecond; k++) {

                isPrimeFirst = true;
                isPrimeSecond = true;
                for (int j = 2; j <= i - 1; j++) {
                    if (i % j == 0) {
                        isPrimeFirst = false;
                    }
                }
                for (int l = 2; l <= k - 1; l++) {
                    if (k % l == 0) {
                        isPrimeSecond = false;
                    }
                }
                if (isPrimeSecond && isPrimeFirst) {
                    System.out.printf("%d%d%n",i,k);
                }
            }

        }


    }
}
