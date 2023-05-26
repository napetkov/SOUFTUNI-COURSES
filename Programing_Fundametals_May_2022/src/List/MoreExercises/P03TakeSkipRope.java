package List.MoreExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputLine = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());
        List<String> nonNumberList = new ArrayList<>();
        List<String> numberList = new ArrayList<>();


        for (int i = 0; i < inputLine.size(); i++) {
            if (inputLine.get(i).charAt(0) >= '0' && inputLine.get(i).charAt(0) <= '9') {
                numberList.add(inputLine.get(i));
            } else {
                nonNumberList.add(inputLine.get(i));
            }
        }
        List<Integer> skipList = new ArrayList<>();
        List<Integer> takeList = new ArrayList<>();
        for (int i = 0; i < numberList.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(Integer.parseInt(numberList.get(i)));
            } else {
                skipList.add(Integer.parseInt(numberList.get(i)));
            }
        }
        int counterIndex = 0;
        String result = "";

        for (int i = 0; i < takeList.size(); i++) {

            for (int j = counterIndex; j < counterIndex + takeList.get(i); j++) {
                if(j>nonNumberList.size()-1){
                    break;
                }
                result += nonNumberList.get(j);
            }
            counterIndex +=takeList.get(i);
            counterIndex += skipList.get(i);


        }


        System.out.println(result);

    }
}
