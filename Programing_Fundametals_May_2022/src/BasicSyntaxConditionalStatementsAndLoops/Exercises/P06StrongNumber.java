package BasicSyntaxConditionalStatementsAndLoops.Exercises;

import java.util.Scanner;

public class P06StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        int number = input;
        int sumFactorial = 0;
        while (number != 0) {
            int digitFactorial = 1;
            int digit = 0;
            digit = number % 10;
            for (int i = 1; i <= digit; i++) {
                digitFactorial = digitFactorial*i;
            }
            sumFactorial +=digitFactorial;

            number = number / 10;
        }

       if(sumFactorial==input){
           System.out.println("yes");
       }else{
           System.out.println("no");
       }

    }
}
