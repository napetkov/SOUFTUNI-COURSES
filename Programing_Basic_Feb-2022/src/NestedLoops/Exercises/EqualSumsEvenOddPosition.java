package NestedLoops.Exercises;

import java.util.Scanner;

public class EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        for (int i = startNumber; i <= secondNumber; i++) {
            String currentNumber = i + "";
            int sumOddPosition = 0;
            int sumEvenPosition = 0;
            for (int j = 0; j < currentNumber.length(); j++) {
                int currentDigit = Integer.parseInt("" + currentNumber.charAt(j));
                if (j % 2 == 0) {
                    sumEvenPosition += currentDigit;
                } else {
                    sumOddPosition += currentDigit;
                }
            }
            if (sumEvenPosition == sumOddPosition) {
                System.out.printf("%d ", i);
            }
        }
    }
}

