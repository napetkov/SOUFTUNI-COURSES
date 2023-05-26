package FunctionalProgramming.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class P03CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");

        Predicate<String> isStartingWithUpperCase = w -> Character.isUpperCase(w.charAt(0));

        List<String> listOfWords = new ArrayList<>();

        Arrays.stream(words)
                .filter(isStartingWithUpperCase)
                .forEach(listOfWords::add);

        System.out.println(listOfWords.size());
        System.out.println(String.join("\n",listOfWords));

    }
}
