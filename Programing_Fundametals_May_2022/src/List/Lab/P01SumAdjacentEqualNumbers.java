package List.Lab;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        for (int i = 0; i < numbersList.size() - 1; i++) {
            double sumCurrentAdjacent = 0;
            double firstEl = numbersList.get(i);
            double secondEl = numbersList.get(i + 1);

            if (firstEl == secondEl) {
                sumCurrentAdjacent = numbersList.get(i) * 2;
                numbersList.set(i, sumCurrentAdjacent);
                numbersList.remove(i + 1);
                i = -1;
            }
        }

        System.out.println(joinElementsByDelimiter(numbersList," "));

    }

    public static String joinElementsByDelimiter(List<Double> list, String delimiter) {
        String result = "";
        for (Double num : list) {
            DecimalFormat df = new DecimalFormat("0.#");

            String numFormat = df.format(num);
            result += numFormat + delimiter;
        }
        return result;
    }
}
