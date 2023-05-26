package FinalExamParparation.Practice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PIrates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> citiesGold = new LinkedHashMap();
        Map<String, Integer> citiesPopulation = new LinkedHashMap();

        while (!input.equals("Sail")) {
            String town = input.split("\\|\\|")[0];
            int people = Integer.parseInt(input.split("\\|\\|")[1]);
            int gold = Integer.parseInt(input.split("\\|\\|")[2]);

            if(citiesPopulation.containsKey(town)){
                int currentGold = citiesGold.get(town);
                int currentPeople = citiesPopulation.get(town);
                citiesGold.put(town,currentGold+gold);
                citiesPopulation.put(town,currentPeople+people);
            }else {
                citiesGold.put(town, gold);
                citiesPopulation.put(town, people);
            }
            input = scanner.nextLine();
        }

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("End")) {
            String command = commandLine.split("=>")[0];
            String town = commandLine.split("=>")[1];
            int gold = 0;
            if ("Plunder".equals(command)) {
                int people = Integer.parseInt(commandLine.split("=>")[2]);
                gold = Integer.parseInt(commandLine.split("=>")[3]);
                int currentGold = citiesGold.get(town);
                int currentPeople = citiesPopulation.get(town);

                if ((currentPeople - people) <= 0 || (currentGold - gold) <= 0) {
                    if(currentPeople-people<=0){
                        people = currentPeople;
                    }
                    if(currentGold<=0){
                        gold = currentGold;
                    }
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);
                    System.out.println(town + " has been wiped off the map!");
                    citiesGold.remove(town);
                    citiesPopulation.remove(town);
                } else {
                    currentGold -= gold;
                    currentPeople -= people;
                    citiesGold.put(town, currentGold);
                    citiesPopulation.put(town, currentPeople);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);
                }
            } else if ("Prosper".equals(command)) {
                gold = Integer.parseInt(commandLine.split("=>")[2]);
                if (gold < 0) {
                    System.out.println("Gold added cannot be a negative number!");
                } else {
                    int currentGold = citiesGold.get(town);
                    currentGold += gold;
                    System.out.printf("%d gold added to the city treasury. %s now has %s gold.%n",gold,town,currentGold);
                    citiesGold.put(town,currentGold);

                }
            }

            commandLine = scanner.nextLine();
        }
            if(citiesGold.isEmpty()){
                System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
            }else {

                System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", citiesGold.size());

                citiesPopulation.entrySet().forEach(entry -> {
                    System.out.printf("%s -> Population: %d citizens, Gold: %d kg %n", entry.getKey(), entry.getValue(), citiesGold.get(entry.getKey()));
                });
            }

    }
}
