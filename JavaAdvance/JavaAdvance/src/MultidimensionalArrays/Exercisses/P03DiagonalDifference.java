package MultidimensionalArrays.Exercisses;

import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int sumDiagonal1 = sumPrimeryDiagonal(matrix);
        int sumDiagonal2 = sumSecondaryDiagonal(matrix);

        System.out.println(Math.abs(sumDiagonal1-sumDiagonal2));

    }

    private static int sumSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        int r = matrix.length - 1;
        int c = 0;
        while (r >= 0 && c < matrix[r].length) {
            sum += matrix[r][c];
            r--;
            c++;
        }
        return sum;
    }

    private static int sumPrimeryDiagonal(int[][] matrix) {
        int sum = 0;
        int r = 0;
        int c = 0;
        while (r < matrix.length && c < matrix[r].length) {
            sum += matrix[r][c];
            r++;
            c++;
        }
        return sum;
    }
}
