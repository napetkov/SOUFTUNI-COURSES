package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class P04AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] prices = Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        DoubleUnaryOperator addVAT = p -> p * 1.20;

        Consumer<double[]> printPrices = p -> {
        System.out.println("Prices with VAT:");
            System.out.println(Arrays.stream(p)
                    .map(addVAT)
                    .mapToObj(d -> String.format("%.2f", d))
                    .collect(Collectors.joining(System.lineSeparator())));
        };

        printPrices.accept(prices);
    }
}
