package SetsAndMapsAdvanced.Exercisses;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> countsSymbols = new TreeMap<>();


        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);

            if (countsSymbols.containsKey(currentSymbol)) {
                countsSymbols.put(currentSymbol, countsSymbols.get(currentSymbol) + 1);
            } else {
                countsSymbols.put(currentSymbol, 1);
            }

        }

        countsSymbols.forEach((k, v) -> {
            System.out.printf("%s: %d time/s%n",k,v);
        });


    }
}
