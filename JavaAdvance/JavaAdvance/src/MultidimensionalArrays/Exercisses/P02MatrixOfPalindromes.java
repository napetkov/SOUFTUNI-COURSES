package MultidimensionalArrays.Exercisses;

import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dimensions = scanner.nextLine();

        int rows = Integer.parseInt(dimensions.split(" ")[0]);
        int columns = Integer.parseInt(dimensions.split(" ")[1]);

        String[][] matrix = new String[rows][columns];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                StringBuilder elements = defineElement(r, c);
                matrix[r][c] = elements.toString();
            }
        }
        for (String []arr:matrix) {
            for(String e:arr){
                System.out.print(e+" ");
            }
            System.out.println();
        }
    }

    private static StringBuilder defineElement(int r, int c) {
        StringBuilder elements = new StringBuilder();
        //a=97
        char a =(char)(97+ r);
        char b = (char)(97+ r + c);
        elements.append(a);
        elements.append(b);
        elements.append(a);
        return elements;
    }
}
