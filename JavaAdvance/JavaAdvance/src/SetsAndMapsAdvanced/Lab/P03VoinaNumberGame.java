package SetsAndMapsAdvanced.Lab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class P03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        LinkedHashSet<Integer> secondDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;

        while (rounds-- > 0){

            int firstCard = firstDeck.iterator().next();
            firstDeck.remove(firstCard);

            int secondCard = secondDeck.iterator().next();
            secondDeck.remove(secondCard);

            if(firstCard>secondCard){
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);
            }else if(firstCard<secondCard){
                secondDeck.add(firstCard);
                secondDeck.add(secondCard);
            }

            if(firstDeck.isEmpty()|| secondDeck.isEmpty()){
                break;
            }
        }
        if(firstDeck.size()== secondDeck.size()){
            System.out.println("Draw!");
        }else if(firstDeck.isEmpty()||firstDeck.size()<secondDeck.size()){
            System.out.println("Second player win!");
        }else if(secondDeck.isEmpty()||secondDeck.size()< firstDeck.size()){
            System.out.println("First player win!");
        }


    }

    private static int[] readNumbers(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
