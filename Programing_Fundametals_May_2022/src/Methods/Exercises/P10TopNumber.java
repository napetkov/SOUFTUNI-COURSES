package Methods.Exercises;

import java.util.Scanner;

public class P10TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        topNumbers(n);

    }

    public static void topNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            if (isTopNumber(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isTopNumber(int n) {
        boolean isDivideToEight = false;
        boolean isOddDigit = false;
        int sumOfN = 0;

        while (n > 0) {
            int currentDigit = n % 10;
            sumOfN +=currentDigit;
            if (currentDigit % 2 != 0) {
                isOddDigit = true;
            }
            n = n / 10;
        }
        if (sumOfN % 8 == 0) {
            isDivideToEight = true;
        }
        if (isDivideToEight && isOddDigit) {
            return true;
        } else {
            return false;
        }
    }

}
