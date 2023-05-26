package MapsLambdaAndStreamAPI.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class P03LegendaryFarming2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> items = new LinkedHashMap<>();
        Map<String, Integer> junkItems = new LinkedHashMap<>();

        items.put("shards", 0);
        items.put("fragments", 0);
        items.put("motes", 0);

        boolean isWin = false;

        while (!isWin) {
            String inputLine = scanner.nextLine().toLowerCase();
            String[] materialArr = inputLine.split(" ");

            for (int i = 0; i <= materialArr.length - 1; i += 2) {
                String material = materialArr[i + 1];
                Integer quantity = Integer.parseInt(materialArr[i]);

                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    Integer currentQuantity = items.get(material);
                    items.put(material, currentQuantity + quantity);
                } else {
                    if (!junkItems.containsKey(material)) {
                        junkItems.put(material, quantity);
                    } else {
                        Integer currentJunk = junkItems.get(material);
                        junkItems.put(material, currentJunk + quantity);
                    }
                }
                if (items.get("shards") >= 250) {
                    System.out.println("Shadowmourne obtained!");
                    items.put("shards", items.get("shards") - 250);
                    isWin = true;
                    break;
                } else if (items.get("fragments") >= 250) {
                    System.out.println("Valanyr obtained!");
                    items.put("fragments", items.get("fragments") - 250);
                    isWin = true;
                    break;
                } else if (items.get("motes") >= 250) {
                    System.out.println("Dragonwrath obtained!");
                    items.put("motes", items.get("motes") - 250);
                    isWin = true;
                    break;
                }
            }
            if (isWin) {
                break;
            }
        }
        items.entrySet().forEach(element -> System.out.printf("%s: %d%n", element.getKey(), element.getValue()));
        junkItems.entrySet().forEach(element -> System.out.printf("%s: %d%n", element.getKey(), element.getValue()));

    }
}
