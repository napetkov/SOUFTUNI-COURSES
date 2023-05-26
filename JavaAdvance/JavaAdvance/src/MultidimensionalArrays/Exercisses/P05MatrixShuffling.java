package MultidimensionalArrays.Exercisses;

import java.util.Arrays;
import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimension = readArray(scanner);
        int rows = dimension[0];
        int columns = dimension[1];

        String[][] matrix = new String[rows][columns];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = scanner.nextLine().split("\\s+");
        }

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            //validationsMatrixLength(columns, matrix);

            String[] commandLine = input.split("\\s+");



            String command = commandLine[0];

            if (command.equals("swap")) {
                //помисли за въвеждане на повече кординати от необходимото
                if (commandLine.length != 5) {

                    printInvalidInput();

                }else{

                    int row1 = Integer.parseInt(commandLine[1]);
                    int col1 = Integer.parseInt(commandLine[2]);
                    int row2 = Integer.parseInt(commandLine[3]);
                    int col2 = Integer.parseInt(commandLine[4]);

                    if (indexValidation(matrix, row1, row2, col1, col2)) {
                        String element = matrix[row1][col1];
                        matrix[row1][col1] = matrix[row2][col2];
                        matrix[row2][col2] = element;
                        printMatrix(matrix);
                    } else {
                        printInvalidInput();
                    }
                }
            } else {
                printInvalidInput();
            }
            input = scanner.nextLine();
        }
        System.out.println();
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    private static boolean indexValidation(String[][] matrix, int row1, int row2, int col1, int col2) {
        return row1 >= 0 && row1 < matrix.length &&
                row2 >= 0 && row2 < matrix.length &&
                col1 >= 0 && col1 < matrix[0].length &&
                col2 >= 0 && col2 < matrix[0].length;
    }

    private static void validationsMatrixLength(int columns, String[][] matrix) {
        if (matrix[0].length != columns) {
            printInvalidInput();
        }
    }

    private static void printInvalidInput() {
        System.out.println("Invalid input!");
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
