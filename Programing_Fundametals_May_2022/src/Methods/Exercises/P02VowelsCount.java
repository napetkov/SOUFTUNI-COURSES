package Methods.Exercises;

import java.util.Scanner;

public class P02VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        System.out.println(countOfVowels(input));


    }

    public static int countOfVowels(String input) {
        int counterVowels = 0;
        input = input.toLowerCase();
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u' || letter == 'y') {
                counterVowels++;
            }

        }


        return counterVowels;
    }

}
