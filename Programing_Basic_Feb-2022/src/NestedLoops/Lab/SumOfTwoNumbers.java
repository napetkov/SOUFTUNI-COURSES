package NestedLoops.Lab;

import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startInterval = Integer.parseInt(scanner.nextLine());
        int endInterval = Integer.parseInt(scanner.nextLine());
        int magicNumber = Integer.parseInt(scanner.nextLine());
        int countCombinations = 0;
        int sum = 0;
        boolean isNotFind = true;
        for (int i = startInterval; i <= endInterval; i++) {
            for (int j = startInterval; j <= endInterval; j++) {
                countCombinations++;
                sum = i + j;
                if (sum == magicNumber) {
                    isNotFind = false;
                    System.out.printf("Combination N:%d (%d + %d = %d)", countCombinations, i, j, magicNumber);
                    break;
                }
            }
            if (!isNotFind) {
                break;
            }
        }
        if (isNotFind) {
            System.out.printf("%d combinations - neither equals %d", countCombinations, magicNumber);
        }
    }
}
