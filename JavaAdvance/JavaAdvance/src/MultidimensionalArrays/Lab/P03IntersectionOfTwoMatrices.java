package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        char[][] matrix1 = new char[rows][columns];
        char[][] matrix2 = new char[rows][columns];
        char[][] expectedMatrix = new char[rows][columns];

        for (int r = 0; r < matrix1.length; r++) {
            matrix1[r] = scanner.nextLine().replace(" ","").toCharArray();
        }
        for (int r = 0; r < matrix2.length; r++) {
            matrix2[r] = scanner.nextLine().replace(" ","").toCharArray();
        }
        for (int r = 0; r < matrix1.length; r++) {
            for (int c = 0; c < matrix1[r].length; c++) {

                if(matrix1[r][c]==matrix2[r][c]){
                    expectedMatrix[r][c]=matrix1[r][c];
                }else{
                    expectedMatrix[r][c]='*';
                }


            }
        }
        for (char[] element:expectedMatrix) {
            for (char character:element) {
                System.out.print(character + " ");
            }
            System.out.println();
        }
    }
}
