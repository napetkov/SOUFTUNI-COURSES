package MultidimensionalArrays.Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][];
        ArrayDeque<Integer> correctNearbyValues = new ArrayDeque<>();

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = readArray(scanner);
        }
        int[] indexes = readArray(scanner);

        int valueToReplace = matrix[indexes[0]][indexes[1]];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == valueToReplace) {
//                    int correctValue = getNearbySum(matrix, r, c, valueToReplace);
//                    matrix[r][c] = correctValue;
                    correctNearbyValues.offer(getNearbySum(matrix, r, c, valueToReplace));
                }
            }
        }
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == valueToReplace) {
                    int correctValue = correctNearbyValues.poll();
                    matrix[r][c] = correctValue;
                }
            }
        }

        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

    }

    private static int getNearbySum(int[][] matrix, int r, int c, int valueToReplace) {
        int nearbySum = 0;

        if (isInBounds(matrix, r, c + 1) && matrix[r][c + 1] != valueToReplace) {
            nearbySum += matrix[r][c + 1];
        }
        if (isInBounds(matrix, r, c - 1) && matrix[r][c - 1] != valueToReplace) {
            nearbySum += matrix[r][c - 1];
        }
        if (isInBounds(matrix, r + 1, c) && matrix[r + 1][c] != valueToReplace) {
            nearbySum += matrix[r + 1][c];
        }
        if (isInBounds(matrix, r - 1, c) && matrix[r - 1][c] != valueToReplace) {
            nearbySum += matrix[r - 1][c];
        }

        return nearbySum;
    }

    private static boolean isInBounds(int[][] matrix, int r, int c) {
        return r >= 0 && c >= 0 && r < matrix.length && c < matrix[r].length;
    }

    private static boolean isoutOfBounds(int[][] matrix, int r, int c) {
        //return r < 0 && c < 0 && r > matrix.length-1 && c > matrix[r].length-1;
        return !isInBounds(matrix, r, c);
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
