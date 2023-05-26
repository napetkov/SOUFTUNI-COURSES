package MultidimensionalArrays.Exercisses;

import javax.swing.*;
import java.util.Scanner;

public class P08TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double damageOfEachTurn = Double.parseDouble(scanner.nextLine());
        double heiganPoints = 3000000;
        int playerPoints = 18500;
        int cloudDamage = 3500;//for two turns
        int eruptionDamage = 6000;
        int startRow = 7;
        int startCol = 7;
        String spell = "";
        boolean plagueFlag = false;
        boolean[][] matrix = new boolean[15][15];

        while (playerPoints > 0 && heiganPoints > 0) {
            heiganPoints -= damageOfEachTurn;
            if (plagueFlag) {
                playerPoints -= 3500;
                plagueFlag = false;
            }

            if (heiganPoints <= 0 || playerPoints <= 0) {
                break;
            }

            String input = scanner.nextLine();
            if(!plagueFlag) {
               matrix = new boolean[15][15];
            }

            spell = input.split("\\s+")[0];
            int attackRow = Integer.parseInt(input.split("\\s+")[1]);
            int attackCol = Integer.parseInt(input.split("\\s+")[2]);

            matrix = damagedZone(matrix, attackRow, attackCol);

            if (validationAttackRowSize(matrix, startRow - 1, startRow + 1) &&
                    validationAttackColumnSize(matrix, startCol - 1, startCol + 1)) {
                if (!matrix[startRow + 1][startCol]) {
                    startRow++;
                } else if (!matrix[startRow][startCol + 1]) {
                    startCol++;
                } else if (!matrix[startRow - 1][startCol]) {
                    startRow--;
                } else if (!matrix[startRow][startCol - 1]) {
                    startCol--;
                }
            }

            if (spell.equals("Cloud")) {
                if (matrix[startRow][startCol]) {
                    playerPoints -= 3500;
                    plagueFlag = true;
                }

            } else if (spell.equals("Eruption")) {

                if (matrix[startRow][startCol]) {
                    playerPoints -= 6000;
                }
            }
        }
        if (spell.equals("Cloud")) {
            spell = "Plague Cloud";
        }
        if (heiganPoints <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heiganPoints);
        }

        if (playerPoints <= 0) {
            System.out.printf("Player: Killed by %s%n", spell);
        } else {
            System.out.printf("Player: %d%n", playerPoints);
        }
        System.out.printf("Final position: %d, %d", startRow, startCol);


    }

//    private static void changePosition(boolean[][] matrix, int startRow, int startCol) {
//        if (validationAttackRowSize(matrix, startRow - 1, startRow + 1) &&
//                validationAttackColumnSize(matrix, startCol - 1, startCol + 1)) {
//            if (matrix[startRow + 1][startCol]) {
//                startRow ++;
//            } else if (matrix[startRow][startCol + 1]) {
//                startCol ++;
//            } else if (matrix[startRow - 1][startCol]) {
//                startRow --;
//            } else if (matrix[startRow][startCol - 1]) {
//                startCol --;
//            }
//        }
//    }

    private static boolean[][] damagedZone(boolean[][] matrix, int attackRow, int attackCol) {
        int startAttackRow = attackRow-1;
        int endAttackRow = attackRow+1;

        if (startAttackRow < 0) {
            startAttackRow = 0;
        }
        if (endAttackRow > matrix.length-1) {
            endAttackRow = matrix.length-1;
        }
        for (int r = startAttackRow; r <= endAttackRow; r++) {
            int startAttackCol = attackCol-1;
            int endAttackCol = attackCol+1;

            if (startAttackCol < 0) {
                startAttackCol = 0;
            }
            if(endAttackCol > matrix[r].length-1) {
                endAttackCol = matrix[r].length - 1;
            }
                for (int c = startAttackCol ; c <= endAttackCol; c++) {
                    matrix[r][c] = true;

                }
            }

        return matrix;
    }

    private static boolean validationAttackColumnSize(boolean[][] matrix, int i, int i1) {
        return i >= 0 && i < matrix.length && i1 >= 0 && i1 < matrix.length;
    }

    private static boolean validationAttackRowSize(boolean[][] matrix, int i, int i1) {
        return i >= 0 && i < matrix.length && i1 >= 0 && i1 < matrix.length;
    }
}
