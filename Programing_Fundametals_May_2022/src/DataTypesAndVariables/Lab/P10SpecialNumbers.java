package DataTypesAndVariables.Lab;

import java.util.Scanner;

public class P10SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sumOfDigits = 0;

        for (int i = 1; i <= n; i++) {
            int number = i;
            sumOfDigits =0;
            while (number>=1) {
                int digit = number % 10;
                sumOfDigits += digit;
                number = number / 10;
            }

            if (sumOfDigits == 5 || sumOfDigits == 7 || sumOfDigits == 11) {
                System.out.printf("%d -> True%n",i);
            } else {
                System.out.printf("%d -> False%n",i);
            }

        }
    }
}
