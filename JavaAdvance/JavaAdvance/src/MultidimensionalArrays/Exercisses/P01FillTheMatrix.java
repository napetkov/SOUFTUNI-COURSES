package MultidimensionalArrays.Exercisses;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int size = Integer.parseInt(input.split(", ")[0]);
        char stile = input.split(", ")[1].charAt(0);
        int[][] matrix = new int[size][size];

        if (stile == 'A') {
            matrix = matrixStileA(matrix, size);

        } else if (stile == 'B') {
            matrix = matrixStileB(matrix, size);

        }

        for (int[] arr:matrix) {
            for (int n:arr) {
                System.out.print(n+" ");
            }
            System.out.println();
        }

    }
    private static int[][] matrixStileB(int[][] matrix, int size) {
        int value = 1;
        for (int c = 0; c < matrix.length; c++) {
            if(c%2==0){
                for (int r = 0; r < matrix[c].length; r++) {
                    matrix[r][c] = value;
                    value++;
                }
            }else{
                for (int r = matrix[c].length-1; r >= 0; r--) {
                    matrix[r][c] = value;
                    value++;
                }
            }

        }

        return matrix;
    }

    private static int[][] matrixStileA(int[][] matrix, int size) {
        int value = 1;
        for (int c = 0; c < matrix.length; c++) {
            for (int r = 0; r < matrix[c].length; r++) {
                matrix[r][c] = value;
                value++;
            }

        }


        return matrix;
    }
}
