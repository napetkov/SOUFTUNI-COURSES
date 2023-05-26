package Methods.Exercises;

import java.util.Scanner;

public class P09PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();
        while (!number.equals("END")) {
            if (isPalindrome(number)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            number = scanner.nextLine();
        }
    }

    public static boolean isPalindrome(String number) {
        boolean isPalindrome = false;
        if (number.length() == 1) {
            isPalindrome = true;
        } else {
            for (int i = 0; i < number.length() / 2; i++) {
                isPalindrome = false;
                if (number.charAt(i) == number.charAt(number.length() - 1 - i)) {
                    isPalindrome = true;
                } else {
                    break;
                }
            }
        }
        return isPalindrome;

    }
}
