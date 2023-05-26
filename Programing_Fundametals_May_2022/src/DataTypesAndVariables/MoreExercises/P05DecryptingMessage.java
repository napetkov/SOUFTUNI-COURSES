package DataTypesAndVariables.MoreExercises;

import java.util.Scanner;

public class P05DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            char letter = scanner.nextLine().charAt(0);
            String decrypt = Character.toString(letter+key);
            System.out.print(decrypt);

        }


    }
}
