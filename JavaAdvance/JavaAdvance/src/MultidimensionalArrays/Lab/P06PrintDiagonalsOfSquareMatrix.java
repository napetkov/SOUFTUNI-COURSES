package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int rows = 0;
        int columns = 0;
        while(rows< matrix.length){
            System.out.print(matrix[rows][columns]+" ");
        rows++;
        columns++;
        }
        rows = matrix.length-1;
        columns = 0;
        System.out.println();
        while (rows>=0){
            System.out.print(matrix[rows][columns]+" ");
            rows--;
            columns++;
        }

    }
}
