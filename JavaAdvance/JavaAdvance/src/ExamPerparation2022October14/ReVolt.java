package ExamPerparation2022October14;

import java.util.Scanner;

public class ReVolt {
    public static int playerRow;
    public static int playerColumn;
    public static boolean isWon;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfTheMatrix = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[sizeOfTheMatrix][sizeOfTheMatrix];

        int numberOfCommands = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < matrix.length; i++) {
            String input = scanner.nextLine();
            matrix[i] = input.toCharArray();
            if (input.contains("f")) {
                playerRow = i;
                playerColumn = input.indexOf('f');
            }
        }

        for (int i = 0; i < numberOfCommands; i++) {
            String command = scanner.nextLine();


            if ("up".equals(command)) {
                movePlayerUp(matrix);
            } else if ("down".equals(command)) {
                movePlayerDown(matrix);
            } else if ("left".equals(command)) {
                movePlayerLeft(matrix);
            } else if ("right".equals(command)) {
                movePlayerRight(matrix);
            }

            if (isWon) {
                print(matrix);
                break;
            }
        }
        if (!isWon) {
            System.out.println("Player lost!");
            print(matrix);
        }

    }

    private static void movePlayerRight(char[][] matrix) {
        int nextColumn = playerColumn + 1;
        int nextRow = playerRow;
        nextColumn = checkNextColumnOutOfBounds(matrix, nextColumn);
        char nextPosition = matrix[playerRow][nextColumn];

        if (nextPosition == 'B') {
            nextColumn++;
            nextColumn = checkNextColumnOutOfBounds(matrix, nextColumn);
        }
        movePlayer(matrix, nextRow, nextColumn, nextPosition);
    }

    private static void print(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static void movePlayerLeft(char[][] matrix) {
        int nextColumn = playerColumn - 1;
        int nextRow = playerRow;
        nextColumn = checkNextColumnOutOfBounds(matrix, nextColumn);
        char nextPosition = matrix[playerRow][nextColumn];

        if (nextPosition == 'B') {
            nextColumn--;
            nextColumn = checkNextColumnOutOfBounds(matrix, nextColumn);
        }
        movePlayer(matrix, nextRow, nextColumn, nextPosition);

    }

    private static void movePlayerUp(char[][] matrix) {
        int nextRow = playerRow - 1;
        int nextColumn = playerColumn;
        nextRow = checkNextRowOutOfBounds(matrix, nextRow);
        char nextPosition = matrix[nextRow][playerColumn];

        if (nextPosition == 'B') {
            nextRow--;
            nextRow = checkNextRowOutOfBounds(matrix, nextRow);
        }
        movePlayer(matrix, nextRow, nextColumn, nextPosition);
    }

    private static void movePlayer(char[][] matrix, int nextRow, int nextColumn, char nextPosition) {
        nextPosition = matrix[nextRow][nextColumn];
        if (nextPosition == 'F') {
            System.out.println("Player won!");
            isWon = true;
        } else if (nextPosition == 'T') {
            return;
        }
            matrix[playerRow][playerColumn] = '-';
            playerRow = nextRow;
            playerColumn = nextColumn;
            matrix[playerRow][playerColumn] = 'f';

    }

    private static void movePlayerDown(char[][] matrix) {
        int nextRow = playerRow + 1;
        int nextColumn = playerColumn;
        nextRow = checkNextRowOutOfBounds(matrix, nextRow);
        char nextPosition = matrix[nextRow][playerColumn];

        if (nextPosition == 'B') {
            nextRow++;
            nextRow = checkNextRowOutOfBounds(matrix, nextRow);
        }
        movePlayer(matrix, nextRow, nextColumn, nextPosition);
    }


    private static int checkNextRowOutOfBounds(char[][] matrix, int nextRow) {
        if (nextRow < 0) {
            nextRow = matrix.length - 1;
        } else if (nextRow >= matrix.length) {
            nextRow = 0;
        }
        return nextRow;
    }

    private static int checkNextColumnOutOfBounds(char[][] matrix, int nextColumn) {
        if (nextColumn < 0) {
            nextColumn = matrix.length - 1;
        } else if (nextColumn >= matrix.length) {
            nextColumn = 0;
        }
        return nextColumn;
    }

}
