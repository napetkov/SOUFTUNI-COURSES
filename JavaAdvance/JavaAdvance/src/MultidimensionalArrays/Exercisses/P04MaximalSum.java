package MultidimensionalArrays.Exercisses;

import java.util.Arrays;
import java.util.Scanner;

public class P04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = readArray(scanner);
        int rows = dimensions[0];
        int columns = dimensions[1];

        int[][] matrix = new int[rows][columns];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = readArray(scanner);
        }
        int maxSum = Integer.MIN_VALUE;
        int[][] maxMatrix = new int[3][3];

        for (int r = 0; r < matrix.length - 2; r++) {
            for (int c = 0; c < matrix[r].length - 2; c++) {
              //може да се направи с 2 for цикъла до r-3 и c-3
                int sum = 0;
                sum += matrix[r][c];
                sum += matrix[r][c+1];
                sum += matrix[r][c+2];
                sum += matrix[r+1][c];
                sum += matrix[r+1][c+1];
                sum += matrix[r+1][c+2];
                sum += matrix[r+2][c];
                sum += matrix[r+2][c+1];
                sum += matrix[r+2][c+2];
                if(sum>maxSum){
                    maxSum = sum;
                    // също с 2 for цикъла,като погоре,но пазим само стартовият индекс на maxMatrix
                 maxMatrix[0][0] = matrix[r][c];
                 maxMatrix[0][1] = matrix[r][c+1];
                 maxMatrix[0][2] = matrix[r][c+2];
                 maxMatrix[1][0] = matrix[r+1][c];
                 maxMatrix[1][1] = matrix[r+1][c+1];
                 maxMatrix[1][2] = matrix[r+1][c+2];
                 maxMatrix[2][0] = matrix[r+2][c];
                 maxMatrix[2][1] = matrix[r+2][c+1];
                 maxMatrix[2][2] = matrix[r+2][c+2];
                }
            }

        }

        System.out.println("Sum = "+maxSum);
        for(int[] arr:maxMatrix){
            for (int n:arr){
                System.out.print(n+" ");
            }
            System.out.println();
        }
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
