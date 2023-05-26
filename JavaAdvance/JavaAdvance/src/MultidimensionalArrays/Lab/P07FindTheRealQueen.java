package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class P07FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] chessBoard = new char[8][8];

        for (int c = 0; c < chessBoard.length; c++) {
            chessBoard[c] = scanner.nextLine().replace(" ", "").toCharArray();
        }

        for (int r = 0; r < chessBoard.length; r++) {
            for (int c = 0; c < chessBoard[r].length; c++) {
                if (chessBoard[r][c] == 'q') {
                    if (isTheRealQueen(chessBoard, r, c)) {
                        System.out.println(r + " " + c);
                    }
                }

            }
        }

    }

    private static boolean isTheRealQueen(char[][] chessBoard, int r, int c) {
        int indexRow = r;
        int indexColumn = c;


        while (r > 0) {
            r--;
            if (chessBoard[r][c] == 'q') {
                return false;
            }
        }
        r = indexRow;
        c = indexColumn;
        while (r < chessBoard.length-1) {
            r++;
            if (chessBoard[r][c] == 'q') {
                return false;
            }
        }
        r = indexRow;
        c = indexColumn;

        while (c > 0) {
            c--;
            if (chessBoard[r][c] == 'q') {
                return false;
            }
        }
        r = indexRow;
        c = indexColumn;

        while (c < chessBoard[r].length-1) {
            c++;
            if (chessBoard[r][c] == 'q') {
                return false;
            }
        }
        r = indexRow;
        c = indexColumn;

        while (r > 0 && c > 0) {
            r--;
            c--;
            if (chessBoard[r][c] == 'q') {
                return false;
            }
        }
        r = indexRow;
        c = indexColumn;

        while (r < chessBoard.length-1 && c < chessBoard[r].length-1) {
            r++;
            c++;
            if (chessBoard[r][c] == 'q') {
                return false;
            }
        }
        r = indexRow;
        c = indexColumn;

        while (r < chessBoard.length-1 && c > 0) {
            r++;
            c--;
            if (chessBoard[r][c] == 'q') {
                return false;
            }
        }
        r = indexRow;
        c = indexColumn;

        while (r > 0 && c < chessBoard[r].length-1) {
            r--;
            c++;
            if (chessBoard[r][c] == 'q') {
                return false;
            }
        }
        r = indexRow;
        c = indexColumn;

        return true;
    }


}
