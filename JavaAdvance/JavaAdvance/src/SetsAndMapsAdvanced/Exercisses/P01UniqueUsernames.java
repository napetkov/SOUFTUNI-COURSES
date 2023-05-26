package SetsAndMapsAdvanced.Exercisses;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersOfInputs = Integer.parseInt(scanner.nextLine());

        Set<String> usernames = new LinkedHashSet<>();

        for (int i = 0; i < numbersOfInputs; i++) {

            String input = scanner.nextLine();
            usernames.add(input);
        }

        usernames.forEach(e-> System.out.println(e));


    }
}
