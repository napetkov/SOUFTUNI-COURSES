package List.MoreExercises;

import java.util.*;
import java.util.stream.Collectors;

public class P04MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> number1List = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> number2List = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> listToPrint = new ArrayList<>();

        int rangeNumber1 = 0;
        int rangeNumber2 = 0;

        if (number1List.size() > number2List.size()) {
            if (number1List.get(number1List.size() - 2) < number1List.get(number1List.size() - 1)) {

                rangeNumber1 = number1List.get(number1List.size() - 2);
                rangeNumber2 = number1List.get(number1List.size() - 1);
            } else if (number1List.get(number1List.size() - 2) > number1List.get(number1List.size() - 1)) {

                rangeNumber2 = number1List.get(number1List.size() - 2);
                rangeNumber1 = number1List.get(number1List.size() - 1);
            }

        } else if (number1List.size() < number2List.size()) {
            if (number2List.get(0) < number2List.get(1)) {

                rangeNumber1 = number2List.get(0);
                rangeNumber2 = number2List.get(1);
            } else if (number2List.get(0) > number2List.get(1)) {

                rangeNumber2 = number2List.get(0);
                rangeNumber1 = number2List.get(1);
            }
        }

        for (int currentNumber : number1List) {
            if (currentNumber > rangeNumber1 && currentNumber < rangeNumber2) {
                listToPrint.add(currentNumber);
            }
        }
        for (int currentNumber : number2List) {
            if (currentNumber > rangeNumber1 && currentNumber < rangeNumber2) {
                listToPrint.add(currentNumber);
            }
        }
        Collections.sort(listToPrint);
        System.out.println(listToPrint.toString().replaceAll("[\\[\\],]",""));
    }
}
