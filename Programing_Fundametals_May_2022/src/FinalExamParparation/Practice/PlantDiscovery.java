package FinalExamParparation.Practice;

import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String> plantsRarity = new LinkedHashMap<>();
        Map<String, List<Integer>> plantRating = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String plant = input.split("<->")[0];
            String rarity = input.split("<->")[1];

            plantsRarity.put(plant, rarity);

        }

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("Exhibition")) {
            String command = commandLine.split(": ")[0];
            String plant = "";
            switch (command) {
                case "Rate":
                    plant = commandLine.split(": ")[1].split(" - ")[0];
                    int rating = Integer.parseInt(commandLine.split(": ")[1].split(" - ")[1]);
                    if (!plantsRarity.containsKey(plant)) {
                        System.out.println("error");
                    } else {
                        if (plantRating.containsKey(plant)) {
                            plantRating.get(plant).add(rating);
                        } else {
                            plantRating.put(plant, new ArrayList<>());
                            plantRating.get(plant).add(rating);
                        }
                    }
                    break;
                case "Update":
                    plant = commandLine.split(": ")[1].split(" - ")[0];
                    String rarity = commandLine.split(": ")[1].split(" - ")[1];
                    if (plantsRarity.containsKey(plant)) {
                        plantsRarity.put(plant, rarity);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Reset":
                    plant = commandLine.split(": ")[1];
                    if (plantsRarity.containsKey(plant)) {
                        plantRating.put(plant, new ArrayList<>());
                    } else {
                        System.out.println("error");
                    }
                    break;
            }
            commandLine = scanner.nextLine();
        }

        Map<String, Double> ratingToPrint = new LinkedHashMap<>();

        plantRating.entrySet().forEach(entry -> {
            String plant = entry.getKey();
            int length = entry.getValue().size();
            List<Integer> ratingList = entry.getValue();

            int averageRating = ratingList.stream().mapToInt(Integer::intValue).sum();

            if (entry.getValue().isEmpty()) {

                ratingToPrint.put(plant, 0.0);
            } else {
                ratingToPrint.put(plant, averageRating * 1.00 / length);
            }

        });

        System.out.println("Plants for the exhibition:");
        plantsRarity.entrySet().forEach(entry -> {
            if(ratingToPrint.isEmpty()){
                System.out.printf("- %s; Rarity: %s; Rating: 0.00%n", entry.getKey(), entry.getValue());
            }else {
                System.out.printf("- %s; Rarity: %s; Rating: %.2f%n", entry.getKey(), entry.getValue(), ratingToPrint.get(entry.getKey()));
            }
        });


    }
}
