package MultidimensionalArrays.Exercisses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P07Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int row = dimensions[0];
        int columns = dimensions[1];
        int[][] matrix = new int[row][columns];
        int n = 1;
        matrix = writeMatrix(matrix, n);
        String input = scanner.nextLine();
        //пробвай да напълниш списък с елементи за премахване
        //при записване на новата матрица,ако не са в този списък да не се записват!!!
        while (!input.equals("Nuke it from orbit")) {
            int[][] destroyedMatrix = new int[row][columns];
            int destroyRow = Integer.parseInt(input.split("\\s+")[0]);
            int destroyColumn = Integer.parseInt(input.split("\\s+")[1]);
            int radios = Integer.parseInt(input.split("\\s+")[2]);

            if (validationDestroingPoint(matrix, destroyRow, destroyColumn, radios)) {
                int r1 = 0;
                for (int r = 0; r < matrix.length; r++) {
                    int c1 = 0;
                    for (int c = 0; c < matrix[r].length; c++) {
                        if (!isInDestroedDiapazon(destroyRow, destroyColumn, radios, r, c)) {
                            if (validationOfDestroyIndexes(matrix, r, c)) {
                                destroyedMatrix[r1][c1] = matrix[r][c];
                                c1++;
                            }
                        }
                    }
                    r1++;
                }
            }

            matrix = destroyedMatrix;
            input = scanner.nextLine();
        }
        for(int[] arr:matrix){
            for (int element:arr){
                if(element==0){
                    System.out.print("  ");
                }else{
                    System.out.print(element+" ");
                }
            }
            System.out.println();
        }
    }

    private static boolean isInDestroedDiapazon(int destroyRow, int destroyColumn, int radios, int r, int c) {
        return (r == destroyRow && c >= destroyColumn - radios && c <= destroyColumn + radios)
                || (c == destroyColumn && r >= destroyRow - radios && r <= destroyRow + radios);
    }

    private static boolean validationOfDestroyIndexes(int[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

    private static boolean validationDestroingPoint(int[][] matrix, int row, int column, int radios) {
        return row >= 0 && row < matrix.length && column < matrix[0].length && column >= 0 && radios >= 0;
    }

    private static int[][] writeMatrix(int[][] matrix, int n) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = n;
                n++;
            }
        }
        return matrix;
    }
}
