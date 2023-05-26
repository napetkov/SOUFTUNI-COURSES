package Arrays.MoreExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P02PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfRows = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfRows; i++) {
            int[] rowArray = new int[i];
            rowArray[0] = 1;
            rowArray[rowArray.length-1]=1;
            if(i<=2) {
                for (int j = 1; j < rowArray.length - 1; j++) {
                    rowArray[j] = rowArray[j - 1] + rowArray[j + 1];

                }
                System.out.println(Arrays.toString(rowArray));
            }else{
                int[] newRowArray = new int[i];
                newRowArray[0] = 1;
                newRowArray[newRowArray.length-1]=1;
                for (int j = 1; j <newRowArray.length-1 ; j++) {
                    newRowArray[j] = rowArray[j-1]+rowArray[j];

                }
                System.out.println(Arrays.toString(newRowArray));
            }
        }


    }
}
