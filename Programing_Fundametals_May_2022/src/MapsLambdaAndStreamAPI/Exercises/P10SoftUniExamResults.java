package MapsLambdaAndStreamAPI.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Integer> mapPoints = new LinkedHashMap<>();
        Map<String, Integer> mapCount = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("exam finished")) {
            String student = input.split("-")[0];
            String language = input.split("-")[1];


            if (!language.equals("banned")) {
                int points = Integer.parseInt(input.split("-")[2]);

                if(mapPoints.containsKey(student)){
                    int currentPoints = mapPoints.get(student);
                    if(currentPoints<= points){
                        mapPoints.put(student, points);
                    }
                }else{
                    mapPoints.put(student,points);
                }

                if (!mapCount.containsKey(language)) {
                    mapCount.put(language, 1);
                } else {
                    mapCount.put(language, mapCount.get(language) + 1);
                }

            } else {
                mapPoints.remove(student);

            }
            input = scanner.nextLine();
        }

        System.out.println("Results:");
        mapPoints.entrySet().forEach(entry -> System.out.println(entry.getKey()+" | "+entry.getValue()));
        System.out.println("Submissions:");
        mapCount.entrySet().forEach(entry-> System.out.println(entry.getKey() + " - "+entry.getValue()));

    }
}
