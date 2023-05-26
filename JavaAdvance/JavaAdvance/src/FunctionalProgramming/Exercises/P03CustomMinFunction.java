package FunctionalProgramming.Exercises;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> functionMin = arr -> Arrays.stream(arr).min().orElseThrow(IllegalArgumentException::new);
       // Function<int[], Integer> functionMIn = arr -> Collections.min(Arrays.stream(arr).boxed().collect(Collectors.toList()));

    int min = functionMin.apply(numbers);

        System.out.println(min);

    }
}
