package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        Function<List<Integer>,Integer> functionIndex = numbers->{
                int min = numbers.stream().mapToInt(p->p).min().getAsInt();
                int index = numbers.lastIndexOf(min);
                return index;
        };


        System.out.println(functionIndex.apply(list));
    }


}
