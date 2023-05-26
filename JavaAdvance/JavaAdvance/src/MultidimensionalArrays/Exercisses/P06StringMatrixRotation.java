package MultidimensionalArrays.Exercisses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rotation = scanner.nextLine();
        int rotationDegree = Integer.parseInt(rotation.replaceAll("[^0-9]", ""));

        String input = scanner.nextLine();
        List<String> inputStrings = new ArrayList<>();
        int maxLengthInput = Integer.MIN_VALUE;

        while (!input.equals("END")) {
            inputStrings.add(input);
            if (input.length() > maxLengthInput) {
                maxLengthInput = input.length();
            }

            input = scanner.nextLine();
        }

        char[][] matrix = new char[inputStrings.size()][maxLengthInput];

        matrix = writeMatrix(inputStrings, matrix);
        int numbersOfRotation = rotationDegree % 360/90;

        for (int i = 0; i < numbersOfRotation; i++) {

            char[][] rotatedMatrix = new char[matrix[0].length][matrix.length];
            rotatedMatrix = rotateMatrixBy90Degrees(matrix, rotatedMatrix);
            matrix = new char[rotatedMatrix.length][rotatedMatrix[0].length];
            matrix = rotatedMatrix;
        }

        for(char[] arr: matrix){
            for(char element:arr){
                System.out.print(element);
            }
            System.out.println();
        }

    }

    private static char[][] rotateMatrixBy90Degrees(char[][] matrix, char[][] rotatedMatrix) {
        int matrixColumns = 0;
        for (int r = 0; r < rotatedMatrix.length; r++) {
            int matrixRows = matrix.length - 1;
            for (int c = 0; c < rotatedMatrix[r].length; c++) {
                rotatedMatrix[r][c] = matrix[matrixRows][matrixColumns];
                matrixRows--;
            }
            matrixColumns++;
        }
        return rotatedMatrix;
    }

    private static char[][] writeMatrix(List<String> inputStrings, char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (c >= inputStrings.get(r).length()) {
                    matrix[r][c] = ' ';
                } else {
                    matrix[r][c] = inputStrings.get(r).charAt(c);
                }
            }
        }
        return matrix;
    }
}
