package Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P02CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArr = scanner.nextLine().split(" " );
        String[] secondArr = scanner.nextLine().split(" " );
        for (String currentSecondString:secondArr
             ) {
            for (String currentFirstString:firstArr
                 ) {
                if(currentSecondString.equals(currentFirstString)){
                    System.out.print(currentSecondString +" ");
                }

            }
            
        }        


    }
}
