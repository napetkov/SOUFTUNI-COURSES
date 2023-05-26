package ExamPerparation2022October17;

import java.util.Scanner;

public class Bee {
    private static int beeRow;
    private static int beeCol;
    private static int countOfpollinate;
    private static boolean programEnd = false;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[sizeOfMatrix][sizeOfMatrix];


        for (int rows = 0; rows < sizeOfMatrix; rows++) {
            String input = scanner.nextLine();
            matrix[rows] = input.toCharArray();
            if (input.contains("B")) {
                beeRow = rows;
                beeCol = input.indexOf('B');
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            if ("up".equals(command)) {
                beeMove(matrix, -1, 0);
            } else if ("down".equals(command)) {
                beeMove(matrix, 1, 0);
            } else if ("left".equals(command)) {
                beeMove(matrix, 0, -1);
            } else if ("right".equals(command)) {
                beeMove(matrix, 0, 1);
            }
            if(programEnd){
                break;
            }
            command = scanner.nextLine();
        }

        if (countOfpollinate >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", countOfpollinate);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - countOfpollinate);
        }
        print(matrix);

    }

    private static void beeMove(char[][] matrix, int rowMutator, int colMutator) {
        boolean bonusNotDone = true;
        int nextRow = beeRow + rowMutator;
        int nextCol = beeCol + colMutator;

        matrix[beeRow][beeCol] = '.';

        if (beeOutOfBounds(matrix, nextCol, nextRow)) {
            System.out.println("The bee got lost!");
            programEnd = true;
        }else {

            char nextPosition = matrix[nextRow][nextCol];

            if (nextPosition == 'O') {
                beeRow = nextRow;
                beeCol = nextCol;
                beeMove(matrix, rowMutator, colMutator);
                bonusNotDone = false;

            }
            if (nextPosition == 'f') {
                countOfpollinate++;
            }
            if (bonusNotDone) {
                matrix[nextRow][nextCol] = 'B';
                beeRow = nextRow;
                beeCol = nextCol;
            }
        }
    }

    private static boolean beeOutOfBounds(char[][] matrix, int nextCol, int nextRow) {
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
