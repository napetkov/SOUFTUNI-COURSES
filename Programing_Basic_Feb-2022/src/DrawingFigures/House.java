package DrawingFigures;

import java.util.Scanner;

public class House {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int rowEven = 1;
        int rowOdd = 0;
        for (int i = 0; i < (n + 1) / 2; i++) {
            if (n % 2 == 0) {
                for (int j = 0; j < (n - rowEven - i) / 2; j++) {
                    System.out.print("-");
                }
                for (int j = 0; j < rowEven; j++) {
                    System.out.print("**");
                }
                for (int j = 0; j < (n - rowEven - i) / 2; j++) {
                    System.out.print("-");
                }
            } else {
                for (int j = 0; j < (n - rowOdd - i) / 2; j++) {
                    System.out.print("-");
                }
                for (int j = 0; j < 2 * rowOdd + 1; j++) {
                    System.out.print("*");
                }
                for (int j = 0; j < (n - rowOdd - i) / 2; j++) {
                    System.out.print("-");
                }
            }
            rowEven++;
            rowOdd++;
            System.out.println();
        }
        for (int i = 0; i <= n / 2 - 1; i++) {
            System.out.print("|");
            for (int j = 0; j < n - 2; j++) {
                System.out.print("*");
            }
            System.out.print("|");
            System.out.println();
        }
    }
}

