package OtherPractis;

import java.util.Scanner;

public class NineDigitNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();


        for (int i = number.length()-1; 0 <= i; i--) {
            char symbol =number.charAt(i);
            System.out.printf("%s",symbol);

        }


    }
}
