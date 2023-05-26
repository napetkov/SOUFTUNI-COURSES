package DataTypesAndVariables.Lab;

import java.util.Scanner;

public class P12RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int currentNumber = 0;
        boolean isSpecial = false;
        for (int i = 1; i <= number; i++) {
            currentNumber = i;
            while (i > 0) {
                sum += i % 10;
                i = i / 10;
            }
            isSpecial = (sum == 5) || (sum == 7) || (sum == 11);
            if(isSpecial){
                System.out.printf("%d -> True%n", currentNumber);
            }else{
                System.out.printf("%d -> False%n", currentNumber);
            }
            sum = 0;
            i = currentNumber;
        }

    }
}
