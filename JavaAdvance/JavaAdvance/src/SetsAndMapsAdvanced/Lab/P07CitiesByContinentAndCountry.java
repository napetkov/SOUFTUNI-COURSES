package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String,Map<String, List<String>>> continents = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            String continent = input.split("\\s+")[0];
            String country = input.split("\\s+")[1];
            String city = input.split("\\s+")[2];

            continents.putIfAbsent(continent,new LinkedHashMap<>());

            Map<String,List<String>> countries = continents.get(continent);

            countries.putIfAbsent(country,new ArrayList<>());

            List<String> cities = countries.get(country);

            cities.add(city);

        }

        continents.forEach((element,map)->{
            System.out.println(element+":");
            map.forEach((key,list)->{
                System.out.print("  "+key + " -> ");
                System.out.println(String.join(", ",list));
            });
        });



    }
}
