package TextProcessing.Exercises;

import java.util.Scanner;

public class P01ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] usernames = scanner.nextLine().split(", ");

        for (String user : usernames) {
            if (isValidCharacter(user) && isValidLength(user)) {
                System.out.println(user);
            }
        }


    }

    public static boolean isValidLength(String user) {
        return user.length() >= 3 && user.length() <= 16;
    }

    public static boolean isValidCharacter(String user) {
        if (user.length() < 3 || user.length() > 16) {
            return false;
        }
        for (char symbol : user.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol) && symbol != '_' && symbol != '-') {
                return false;
            }
        }
        return true;
    }
}
