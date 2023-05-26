package Methods.Exercises;

import java.util.Scanner;

public class P06MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        System.out.println(middleCharacter(input));
    }

    public static String middleCharacter(String input) {
        String middleCharacter = "";
        if (input.length() % 2 == 0) {
            middleCharacter = Character.toString(input.charAt(input.length() / 2 - 1)) + input.charAt(input.length() / 2);
        } else {
            middleCharacter = Character.toString(input.charAt(input.length() / 2));

        }

        return middleCharacter;
    }

}
