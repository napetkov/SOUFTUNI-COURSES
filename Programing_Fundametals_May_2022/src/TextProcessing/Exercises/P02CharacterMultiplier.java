package TextProcessing.Exercises;

import java.util.Scanner;

public class P02CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String str1 = input.split(" ")[0];
        String str2 = input.split(" ")[1];
        int totalSum = 0;

        if (str1.length() > str2.length()) {
            int multiply = 0;
            for (int i = 0; i < str2.length(); i++) {
                multiply = str1.charAt(i) * str2.charAt(i);
                totalSum += multiply;
            }
            for (int i = str2.length(); i < str1.length(); i++) {
                totalSum += str1.charAt(i);
            }
        } else {
            int multiply = 0;
            for (int i = 0; i < str1.length(); i++) {
                multiply = str1.charAt(i) * str2.charAt(i);
                totalSum += multiply;
            }
            for (int i = str1.length(); i < str2.length(); i++) {
                totalSum += str2.charAt(i);
            }
        }
        System.out.println(totalSum);

    }
}
