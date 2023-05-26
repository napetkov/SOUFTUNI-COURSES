package MapsLambdaAndStreamAPI.Exercises;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P01CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        Map<Character,Integer> characterMap = new LinkedHashMap<>();

        for(char symbol:text.toCharArray()){

            Integer currentCount = characterMap.get(symbol);

            if(characterMap.containsKey(symbol)){
                characterMap.put(symbol,currentCount+1);
            }else{
                characterMap.put(symbol,1);
            }
        }
        characterMap.remove(' ');

        for (Map.Entry<Character, Integer> entry : characterMap.entrySet()) {
            System.out.printf("%c -> %d%n",entry.getKey(),entry.getValue());
        }


    }
}
