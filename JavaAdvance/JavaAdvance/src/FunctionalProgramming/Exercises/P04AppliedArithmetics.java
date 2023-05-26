package FunctionalProgramming.Exercises;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P04AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        UnaryOperator<List<Integer>> add = numbers -> numbers.stream().map(n -> n + 1).collect(Collectors.toList());

        UnaryOperator<List<Integer>> multiply = numbers -> numbers.stream().map(n -> n * 2).collect(Collectors.toList());

        UnaryOperator<List<Integer>> subtract = numbers -> numbers.stream().map(n -> n - 1).collect(Collectors.toList());

        Consumer<List<Integer>> printer = numbers -> numbers.forEach(n -> System.out.print(n + " "));

        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    list = add.apply(list);
                    break;
                case "multiply":
                    list = multiply.apply(list);
                    break;
                case "subtract":
                    list = subtract.apply(list);
                    break;
                case "print":
                    printer.accept(list);
                    System.out.println();
                    break;

            }


            command = scanner.nextLine();
        }


    }
}
