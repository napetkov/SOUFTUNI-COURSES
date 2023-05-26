package DrawingFigures;

import java.util.Scanner;

public class TriangleOfDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int rows = 0;
        for (int i = 0; i <n; i++) {
                for (int j = 0; j <= rows; j++) {
                    System.out.print("$ ");
                }
            rows++;
            System.out.println();
        }
    }
}
