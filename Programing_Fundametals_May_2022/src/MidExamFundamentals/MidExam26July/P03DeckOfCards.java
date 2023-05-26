package MidExamFundamentals.MidExam26July;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03DeckOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> cardsDeck = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        int numberOfCommand = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCommand; i++) {
            String[] commandLine = scanner.nextLine().split(", ");
            String command = commandLine[0];

            switch (command) {
                case "Add":
                    String card = commandLine[1];

                    if (cardsDeck.contains(card)) {
                        System.out.println("Card is already in the deck");
                    } else {
                        cardsDeck.add(card);
                        System.out.println("Card successfully added");
                    }
                    break;

                case "Remove":
                    card = commandLine[1];
                    if (cardsDeck.contains(card)) {
                        cardsDeck.remove(card);
                        System.out.println("Card successfully removed");
                    } else {
                        System.out.println("Card not found");
                    }
                    break;

                case "Remove At":
                    int index = Integer.parseInt(commandLine[1]);

                    if (isValidIndex(cardsDeck, index)) {
                        cardsDeck.remove(index);
                        System.out.println("Card successfully removed");
                    }else{
                        System.out.println("Index out of range");
                    }
                    break;

                case "Insert":
                    index = Integer.parseInt(commandLine[1]);
                    card = commandLine[2];

                    if(isValidIndex(cardsDeck,index)){
                        if(cardsDeck.contains(card)){
                            System.out.println("Card is already added");
                        }else{
                            cardsDeck.add(index,card);
                            System.out.println("Card successfully added");
                        }
                    }else{
                        System.out.println("Index out of range");
                    }
                    break;


            }

        }
        System.out.println(cardsDeck.toString().replaceAll("[\\[\\]]",""));

    }

    private static boolean isValidIndex(List<String> cardsDeck, int index) {
        return index >= 0 && index < cardsDeck.size();
    }
}
