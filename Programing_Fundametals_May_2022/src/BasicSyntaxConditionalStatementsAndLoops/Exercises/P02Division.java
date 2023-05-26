package BasicSyntaxConditionalStatementsAndLoops.Exercises;

import java.util.Scanner;

public class P02Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int divisibleNum = 0;
        boolean flag = false;
        if (num % 10 == 0) {
            divisibleNum = 10;
            flag = true;
        } else if (num % 7 == 0) {
            divisibleNum = 7;
            flag = true;
        } else if (num % 6 == 0) {
            divisibleNum = 6;
            flag = true;
        } else if (num % 3 == 0) {
            divisibleNum = 3;
            flag = true;
        } else if (num % 2 == 0) {
            divisibleNum = 2;
            flag = true;
        }

        if (flag) {
            System.out.printf("The number is divisible by %d", divisibleNum);
        }else{
            System.out.println("Not divisible");
        }
    }
}
