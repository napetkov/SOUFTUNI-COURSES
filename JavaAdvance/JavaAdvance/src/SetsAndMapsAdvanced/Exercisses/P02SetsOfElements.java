package SetsAndMapsAdvanced.Exercisses;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        
        int lengthFirstSet = Integer.parseInt(input.split("\\s+")[0]);
        int lengthSecondSet = Integer.parseInt(input.split("\\s+")[1]);

        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();
        Set<String> repeatingElements = new LinkedHashSet<>();
        
        
        for (int i = 0; i < lengthFirstSet; i++) {
            input = scanner.nextLine();
            firstSet.add(input);
        }

        for (int i = 0; i < lengthSecondSet; i++) {
            input = scanner.nextLine();
            secondSet.add(input);
        }

        firstSet.forEach(e-> {
            if(secondSet.contains(e))
            System.out.print(e+" ");
        });
    }
}
