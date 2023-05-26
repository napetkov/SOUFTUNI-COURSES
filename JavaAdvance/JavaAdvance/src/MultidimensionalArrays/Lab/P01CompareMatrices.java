package MultidimensionalArrays.Lab;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class P01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rowsFirstMatrix = input[0];
        int columnsFirstMatrix = input[1];

        int[][] firstMatrix = new int[rowsFirstMatrix][columnsFirstMatrix];

        for (int i = 0; i < rowsFirstMatrix; i++) {

            firstMatrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

        }
        input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rowsSecondMatrix = input[0];
        int columnsSecondMatrix = input[1];

        int[][] secondMatrix = new int[rowsSecondMatrix][columnsSecondMatrix];

        for (int i = 0; i < rowsSecondMatrix; i++) {

            secondMatrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

        }
        if (isEqual(firstMatrix, secondMatrix)){
            System.out.println("equal");
        }else{
            System.out.println("not equal");
        }
    }

    private static boolean isEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int r = 0; r < firstMatrix.length; r++) {
            if (firstMatrix[r].length != secondMatrix[r].length) {
                return false;
            }
            for (int c = 0; c < firstMatrix[r].length; c++) {
                if (firstMatrix[r][c] != secondMatrix[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }
}
