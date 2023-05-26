package FoodShortage;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPerson = Integer.parseInt(scanner.nextLine());

        Map<String,Buyer> buyers = new HashMap<>();

        for (int i = 0; i < numberOfPerson; i++) {
            String[] personData = scanner.nextLine().split("\\s+");

            String name = personData[0];
            int age = Integer.parseInt(personData[1]);
            if (personData.length == 4) {
                String id = personData[2];
                String birthDate = personData[3];

                Citizen citizen = new Citizen(name, age, id, birthDate);
                buyers.put(name,citizen);
            } else {
                String group = personData[2];

                Rebel rebel = new Rebel(name, age, group);
                buyers.put(name,rebel);
            }
        }

        String input = scanner.nextLine();

        while(!"End".equals(input)){

            if(buyers.containsKey(input)){
                buyers.get(input).buyFood();
            }


            input = scanner.nextLine();
        }

        System.out.println(buyers.values()
                .stream()
                .mapToInt(Buyer::getFood)
                .sum());
    }
}
