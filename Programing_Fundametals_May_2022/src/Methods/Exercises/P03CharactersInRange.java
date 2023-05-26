package Methods.Exercises;

import java.util.Scanner;

public class P03CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char start = scanner.nextLine().charAt(0);
        char end = scanner.nextLine().charAt(0);
        System.out.println(characterBetween(start, end));


    }

    public static String characterBetween(char start, char end) {
        String result = "";

        if (end < start) {

            for (int i = end + 1; i < start; i++) {
                result += Character.toString(i) + " ";
            }
        } else {

            for (int i = start + 1; i < end; i++) {
                result += Character.toString(i) + " ";
            }
        }

        return result;
    }
}
