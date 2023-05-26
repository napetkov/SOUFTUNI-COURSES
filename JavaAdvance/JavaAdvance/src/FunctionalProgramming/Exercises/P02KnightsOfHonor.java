package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P02KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Consumer<String> printer = p-> System.out.println("Sir "+p);

        Arrays.stream(input.split("\\s+"))
                .forEach(printer);


    }
}
