package SetsAndMapsAdvanced.Exercisses;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = Integer.parseInt(scanner.nextLine());

        Set<String> chemicalElements = new TreeSet<>();


        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int j = 0; j < input.length; j++) {
                chemicalElements.add(input[j]);
            }
        }
        
        chemicalElements.forEach(e-> System.out.print(e+" "));

    }
}
