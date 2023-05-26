package MapsLambdaAndStreamAPI.Lab;

import java.text.DecimalFormat;
import java.util.*;

public class P01CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> mapNums = new TreeMap<>();

        for (double currentNum : numbers) {


            //mapNums.putIfAbsent(currentNum,0) - добави на този ключстойност,ако не съществува

            Integer counterValue = mapNums.get(currentNum);

            if (mapNums.containsKey(currentNum)) {
                mapNums.put(currentNum, counterValue + 1);
            }else{
                mapNums.put(currentNum,1);
            }


//            int counterNumbers = 0;
//            double currentNum = element;
//            for (double integer : numbers) {
//                if (currentNum == integer) {
//                    counterNumbers++;
//                }
//            }
//            if(!mapNums.containsKey(currentNum)) {
//                mapNums.put(currentNum, counterNumbers);
//            }

        }
        for (Map.Entry<Double, Integer> entry : mapNums.entrySet()) {
            DecimalFormat df = new DecimalFormat("#.######");

            System.out.printf("%s -> %d%n", df.format(entry.getKey()), entry.getValue());
        }

    }
}
