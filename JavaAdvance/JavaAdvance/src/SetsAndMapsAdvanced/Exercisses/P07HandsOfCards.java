package SetsAndMapsAdvanced.Exercisses;

import java.util.*;
import java.util.stream.Collectors;

public class P07HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Set<String>> cardSequence = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String name = input.split(": ")[0];
            String drawCards = input.split(": ")[1];

            LinkedHashSet<String> deck = Arrays.stream(drawCards.split(", "))
                    .collect(Collectors.toCollection(LinkedHashSet::new));

            if (cardSequence.containsKey(name)) {
                Set<String> currentSet =new LinkedHashSet<>();
                        currentSet = cardSequence.get(name);
                deck.addAll(currentSet);

                cardSequence.put(name, deck);
            } else {
                cardSequence.put(name, deck);
            }
            input = scanner.nextLine();
        }

        Map<String, Integer> result = new LinkedHashMap<>();

        cardSequence.forEach((k, v) -> {
            int valueOfDeck = sumCardDeck(v);

            System.out.printf("%s: %d%n",k,valueOfDeck);

        });


        System.out.println();


    }

    private static int sumCardDeck(Set<String> v) {
        int sum = 0;
        for (String card : v) {
            String power = card.split("")[0];
            String type = card.split("")[1];

            if(power.equals("1")){
                power = "10";
                type = card.split("")[2];
            }

            sum += cardValue(power, type);
        }
        return sum;
    }

    private static int cardValue(String power, String type) {
        int value = 0;
        Map<String,Integer> powerOfCards = new HashMap<>();
            powerOfCards.put("2",2);
            powerOfCards.put("3",3);
            powerOfCards.put("4",4);
            powerOfCards.put("5",5);
            powerOfCards.put("6",6);
            powerOfCards.put("7",7);
            powerOfCards.put("8",8);
            powerOfCards.put("9",9);
            powerOfCards.put("10",10);
            powerOfCards.put("J",11);
            powerOfCards.put("Q",12);
            powerOfCards.put("K",13);
            powerOfCards.put("A",14);


        int typeValue = 0;
        switch (type){
            case "S":
                typeValue = 4;
                break;
            case "H":
                typeValue = 3;
                break;
            case "D":
                typeValue = 2;
                break;
            case "C":
                typeValue = 1;
                break;
        }

        value = powerOfCards.get(power)*typeValue;

        return value;
    }
}
