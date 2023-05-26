package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Consumer<String> printer = System.out::println;
//на управненичта се праши с Лист
        Arrays.stream(input.split("\\s+")).forEach(printer);



    }
}
