package MapsLambdaAndStreamAPI.MoreExercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P02Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String,Map<String,Integer>> map = new TreeMap<>();

        while(!input.equals("no more time")){
            String student = input.split(" -> ")[0];
            String contest = input.split(" -> ")[1];
            int points = Integer.parseInt(input.split(" -> ")[2]);

            if(!map.containsKey(student)){
                map.put(student,new TreeMap<>());
                map.get(student).put(contest,points);

            }else if(!map.get(student).containsKey(contest)){
                map.get(student).put(contest,points);
            }else{
                int currentPoint= map.get(student).get(contest);
                if(currentPoint<=points){
                    map.get(student).put(contest,points);
                }
            }

            input = scanner.nextLine();
        }



    }
}
