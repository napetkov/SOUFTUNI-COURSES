package MapsLambdaAndStreamAPI.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int counterInputs = 0;
        Map<String,Integer> resources = new LinkedHashMap<>();

        while(!input.equals("stop")){
            int quantity = Integer.parseInt(scanner.nextLine());
            Integer currentQuantity = resources.get(input);
            if(resources.containsKey(input)){
                resources.put(input,currentQuantity+quantity);
            }else{
                resources.put(input,quantity);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            System.out.printf("%s -> %d%n",entry.getKey(),entry.getValue());
        }
//resources.entrySet().forEach(e -> System.out.print(e.getKey()+" -> "+e.getValue()));

    }
}
