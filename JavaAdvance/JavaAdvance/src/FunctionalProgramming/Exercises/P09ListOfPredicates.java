package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P09ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int endOfRange = Integer.parseInt(scanner.nextLine());

        List<Integer> numbersToDivideTo = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Predicate<Integer> isDivisible = number -> {
            for (Integer numberToDivideTo : numbersToDivideTo) {
                if (number % numberToDivideTo != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int i = 1; i <= endOfRange; i++) {
            if(isDivisible.test(i)){
                System.out.print(i + " ");
            }
        }


    }
}
