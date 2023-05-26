package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] realNumber = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> realNumbersMap = new LinkedHashMap<>();

        for (int i = 0; i < realNumber.length; i++) {

            double currentNumber = realNumber[i];

            if (realNumbersMap.containsKey(currentNumber)) {
                int currentValue = realNumbersMap.get(currentNumber);
                realNumbersMap.put(currentNumber, currentValue+1);

            } else {
                realNumbersMap.put(currentNumber, 1);
            }


        }
        realNumbersMap.forEach((k, v) -> System.out.printf("%.1f -> %d%n",k,v));


    }
}
