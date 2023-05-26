import java.util.Scanner;

public class PawnWars {
    private static int whiteRow;
    private static int blackRow;
    private static int whiteCol;
    private static int blackCol;
    private static boolean whiteTurn = true;
    private static boolean whiteWin;
    private static boolean blackWin;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];

        for (int row = 0; row < matrix.length; row++) {
            String input = scanner.nextLine();
            matrix[row] = input.toCharArray();

            if (input.contains("w")) {
                whiteRow = row;
                whiteCol = input.indexOf('w');
            }

            if (input.contains("b")) {
                blackRow = row;
                blackCol = input.indexOf('b');
            }
        }

        while (whiteRow >= 0 && blackRow < matrix.length) {
            if (whiteTurn) {
                matrix[whiteRow][whiteCol] = '-';

                if (whiteRow != 0 && whiteCol != 0) {
                    if (matrix[whiteRow - 1][whiteCol - 1] == 'b') {
                        whiteRow--;
                        whiteCol--;
                        whiteWin = true;
                    }
                }
                if (whiteRow != 0 && whiteCol != matrix.length - 1) {
                    if ((matrix[whiteRow - 1][whiteCol + 1] == 'b')) {
                        whiteRow--;
                        whiteCol++;
                        whiteWin = true;
                    }
                }

                if (!whiteWin) {
                    whiteRow--;
                }
                if (!outOfbounds(matrix)){
                    matrix[whiteRow][whiteCol] = 'w';
                }

                if (whiteWin) {
                    break;
                }


                whiteTurn = false;
            } else {
                matrix[blackRow][blackCol] = '-';

                if (blackRow != matrix.length - 1 && blackCol != 0) {
                    if ((matrix[blackRow + 1][blackCol - 1] == 'w')) {
                        blackRow++;
                        blackCol--;
                        blackWin = true;
                    }
                }
                if (blackRow != matrix.length - 1 && blackCol != matrix.length - 1) {
                    if ((matrix[blackRow + 1][blackCol + 1] == 'w')) {
                        blackRow++;
                        blackCol++;
                        blackWin = true;
                    }
                }

                if (!blackWin) {
                    blackRow++;
                }
                if(!outOfbounds(matrix)){
                    matrix[blackRow][blackCol] = 'b';
                }

                if (blackWin) {
                    break;
                }
                whiteTurn = true;
            }


            System.out.println("<+++++++++>");
            print(matrix);
        }
        if (blackWin) {
            System.out.println("Black win");
        } else if (whiteWin) {
            System.out.println("White win");
        }
        if (whiteRow < 0) {
            System.out.println("white pawn is the QUEEN");
        }
        if (blackRow > matrix.length-1) {
            System.out.println("black pawn is the QUEEN");
        }

    }

    private static boolean outOfbounds(char[][] matrix) {
        return whiteRow < 0 || blackRow > matrix.length - 1;
    }

    public static void print(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }


    }


}
