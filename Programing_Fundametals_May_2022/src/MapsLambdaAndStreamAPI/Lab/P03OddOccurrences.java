package MapsLambdaAndStreamAPI.Lab;

import java.util.*;

public class P03OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toLowerCase();
        String[] inputArr = input.split(" ");


        Map<String, Integer> wordsMaps = new LinkedHashMap<>();


        for (String element : inputArr) {
            wordsMaps.putIfAbsent(element,0);

            Integer currentCount = wordsMaps.get(element);

            if(wordsMaps.containsKey(element)){
                wordsMaps.put(element,currentCount+1);

            }else{
                wordsMaps.put(element,1);

            }

        }
        List<String> printList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordsMaps.entrySet()) {
            if(entry.getValue()%2!=0){
                printList.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ",printList));

    }
}
