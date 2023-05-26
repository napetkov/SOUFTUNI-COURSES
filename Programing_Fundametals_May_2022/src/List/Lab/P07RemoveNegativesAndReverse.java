package List.Lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P07RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numberList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
//        for (int i = 0; i < numberList.size(); i++) {
//            int currentNumber = numberList.get(i);
//            if (currentNumber < 0) {
//                numberList.remove(i);
//                i=-1;
//            }
        numberList.removeIf(e -> e<0);

        if (numberList.isEmpty()) {
            System.out.println("empty");
        }else{
            Collections.reverse(numberList);
            System.out.println(numberList.toString().replaceAll("[\\[\\],]",""));
        }

    }
}
