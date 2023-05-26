package MapsLambdaAndStreamAPI.Exercises;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> materialsMap = new LinkedHashMap<>();
        String material = "";
        int quantity = 0;
        Integer winValue = 0;

        while(winValue<=250) {
            String[] inputLine = scanner.nextLine().split(" ");

            for (int i = 0; i < inputLine.length; i++) {


                if (i % 2 == 0) {
                    quantity = Integer.parseInt(inputLine[i]);
                } else {
                    material = inputLine[i].toLowerCase();
                    Integer currentQuantity = materialsMap.get(material);

                    if (materialsMap.containsKey(material)) {
                        materialsMap.put(material, currentQuantity + quantity);
                    } else {
                        materialsMap.put(material, quantity);
                    }
                    winValue = materialsMap.get(material);
                    if (winValue > 250) {
                        break;
                    }
                }

            }
        }
        if (winValue >= 250) {
            switch (material) {
                case "shards":
                    System.out.println("Shadowmourne obtained!");
                    break;
                case "fragments":
                    System.out.println("Valanyr obtained!");
                    break;
                case "motes":
                    System.out.println("Dragonwrath obtained!");
                    break;
            }
            materialsMap.put(material, winValue - 250);

        }
        for (Map.Entry<String, Integer> entry : materialsMap.entrySet()) {
                if (entry.getKey().equals("shards")) {
                    System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
                }
            }
            if (!materialsMap.containsKey("shards")) {
                System.out.println("shards: 0");
            }
            materialsMap.remove("shards");

            for (Map.Entry<String, Integer> entry : materialsMap.entrySet()) {
                if (entry.getKey().equals("fragments")) {
                    System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
                }
            }
            if (!materialsMap.containsKey("fragments")) {
                System.out.println("fragments: 0");
            }

            materialsMap.remove("fragments");

            for (Map.Entry<String, Integer> entry : materialsMap.entrySet()) {
                if (entry.getKey().equals("motes")) {
                    System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
                }
            }
            if (!materialsMap.containsKey("motes")) {
                System.out.println("motes: 0");
            }
            materialsMap.remove("motes");


//3 Motes 5 stones 5 Shards 6 leathers 255 fragments 7 Shards

            materialsMap.entrySet().forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));
        }
    }

//123 silver 6 shards 8 shards 5 motes 9 fangs 75 motes 103 MOTES 8 Shards 86 Motes 7 stones 19 silver
