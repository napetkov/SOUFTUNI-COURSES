import javax.swing.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> steelSequence = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(steelSequence::offer);

        ArrayDeque<Integer> carbonSequence = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(carbonSequence::push);

        TreeMap<String, Integer> swords = new TreeMap<>();

        while (!steelSequence.isEmpty() && !carbonSequence.isEmpty()) {
            int steel = steelSequence.poll();
            int carbon = carbonSequence.pop();
            int sum = steel + carbon;
            String typeOfSword = "";

            switch (sum) {
                case 70:
                    typeOfSword = "Gladius";
                    forgeSwor(swords, "Gladius");
                    break;
                case 80:
                    forgeSwor(swords, "Shamshir");
                    break;
                case 90:
                    forgeSwor(swords, "Katana");
                    break;
                case 110:
                    forgeSwor(swords, "Sabre");
                    break;
                default:
                    carbon += 5;
                    carbonSequence.push(carbon);
                    break;
            }

        }
        if (swords.isEmpty()) {
            System.out.println("You did not have enough resources to forge a sword.");
        } else {
                int sumOfSwords = 0;
            for (String s : swords.keySet()) {
                sumOfSwords += swords.get(s);
            }
            System.out.printf("You have forged %d swords.%n",sumOfSwords);
        }
        if(steelSequence.isEmpty()){
            System.out.println("Steel left: none");
        }else{
            System.out.print("Steel left: ");
                System.out.println(steelSequence.stream().map(Object::toString).collect(Collectors.joining(", ")));
        }
        if(carbonSequence.isEmpty()){
            System.out.println("Carbon left: none");
        }else{
            System.out.print("Carbon left: ");
            System.out.println(carbonSequence.stream().map(Object::toString).collect(Collectors.joining(", ")));

        }
        swords.forEach( (k,v)-> System.out.printf("%s: %d%n",k,v));

    }

    private static void forgeSwor(TreeMap<String, Integer> swords, String typeOfSword) {
        if (swords.containsKey(typeOfSword)) {
            swords.put(typeOfSword, swords.get(typeOfSword) + 1);
        } else {
            swords.put(typeOfSword, 1);
        }
    }
}
