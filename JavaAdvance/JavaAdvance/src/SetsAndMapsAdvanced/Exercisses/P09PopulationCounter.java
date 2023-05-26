package SetsAndMapsAdvanced.Exercisses;

import java.util.*;

public class P09PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String,Integer> countryPopulation = new HashMap<>();
        Map<String,Map<String,Integer>> citiesPopulation = new HashMap<>();

        while(!input.equals("report")){
            String city = input.split("\\|")[0];
            String country = input.split("\\|")[1];
            int population = Integer.parseInt(input.split("\\|")[2]);

            if(citiesPopulation.containsKey(country)){
                Map<String,Integer> currentCity = new HashMap<>();

                currentCity = citiesPopulation.get(country);

                currentCity.put(city,population);
            }else{
                citiesPopulation.put(country,new LinkedHashMap<>());
                citiesPopulation.get(country).put(city,population);
            }

            input = scanner.nextLine();
        }

        //GET SORTED AND PRINT
        //1.Country by population
        //2.Cities by population
        //3.If two cities is same population -> in order entered.
        System.out.println();





    }
}
