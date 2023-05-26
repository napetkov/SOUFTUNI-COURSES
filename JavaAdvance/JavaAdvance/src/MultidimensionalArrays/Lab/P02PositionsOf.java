package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class P02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();

        int[][] matrix = new int[rows][columns];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = scanner.nextInt();
            }
        }
        int numberToCheck = scanner.nextInt();
        boolean isFound = false;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == numberToCheck) {
                    isFound = true;
                    System.out.printf("%d %d%n",r,c);
                }
            }
        }
        if(!isFound){
            System.out.println("not found");
        }
    }
}
