import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {
    private static int playerRow;
    private static int playerCol;
    private static List<String> path = new ArrayList<>();
    private static boolean isPlayerMove = true;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int n = Integer.parseInt(input.split("\\s+")[0]);
        int m = Integer.parseInt(input.split("\\s")[1]);

        char[][] matrix = new char[n][m];


        for (int row = 0; row < matrix.length; row++) {
            input = scanner.nextLine().replaceAll(" ", "");
            if (input.contains("Y")) {
                playerRow = row;
                playerCol = input.indexOf('Y');
            }
            matrix[row] = input.toCharArray();

        }

        input = scanner.nextLine();

        while (!input.equals("Finish")) {

            switch (input) {
                case "up":
                    movePlayer(matrix, -1, 0);
                    break;
                case "down":
                    movePlayer(matrix, 1, 0);
                    break;
                case "left":
                    movePlayer(matrix, 0, -1);
                    break;
                case "right":
                    movePlayer(matrix, 0, +1);
                    break;
            }

            if(isPlayerMove){
                path.add(input);
            }

            input = scanner.nextLine();
        }

        if (matrix[playerRow][playerCol] == 'X') {
            System.out.println("I've found the treasure!");
            System.out.print("The right path is ");
            System.out.print(String.join(", ",path));
        }else{
            System.out.println("The map is fake!");
        }

    }

    private static void movePlayer(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = playerRow + rowMutator;
        int nextCol = playerCol + colMutator;
        isPlayerMove = true;

        if (playerOutOfBounds(matrix, nextRow, nextCol)) {
            if (nextRow < 0) {
                nextRow = 0;
            } else if (nextRow > matrix.length - 1) {
                nextRow = matrix.length - 1;
            }
            if (nextCol < 0) {
                nextCol = 0;
            } else if (nextCol > matrix.length - 1) {
                nextCol = matrix.length - 1;
            }
            isPlayerMove = false;
        }
        char nextPosition = matrix[nextRow][nextCol];

        if (nextPosition == 'T') {
            isPlayerMove = false;
            return;
        }

        matrix[playerRow][playerCol] = '-';

        if (nextPosition != 'X') {
            matrix[nextRow][nextCol] = 'Y';
        }
        playerRow = nextRow;
        playerCol = nextCol;

    }

    private static boolean playerOutOfBounds(char[][] matrix, int nextRow, int nextCol) {
        return nextRow < 0 || nextRow > matrix.length - 1 || nextCol < 0 || nextCol > matrix[nextRow].length - 1;
    }


    private static void print(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
