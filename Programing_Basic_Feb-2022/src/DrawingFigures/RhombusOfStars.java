package DrawingFigures;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int row = 0;
        for (int j = 1; j <= n; j++) {
            for (int k = 1; k < n - row; k++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int k = 0; k <= row - 1; k++) {
                System.out.print(" *");
            }
            row++;
            System.out.println();
        }
        row--;
        for (int j = 1; j <= n-1; j++) {
            row--;
            for (int k = 1; k < n - row; k++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int k = 0; k <= row - 1; k++) {
                System.out.print(" *");
            }
            System.out.println();
        }


    }
}
