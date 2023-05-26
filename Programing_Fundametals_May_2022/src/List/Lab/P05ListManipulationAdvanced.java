package List.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numberList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            List<String> commandList = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            String command = commandList.get(0);
            List<Integer> manipulationList = new ArrayList<>();
            manipulationList.addAll(numberList);
            switch (command) {
                case "Contains":
                    int containsNumber = Integer.parseInt(commandList.get(1));
                    if (numberList.contains(containsNumber)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    printEvenOddElements(manipulationList, commandList.get(1));
                    break;
                case "Get":
                    getSumOfAllNumbers(numberList);
                    break;
                case "Filter":
                    String condition = commandList.get(1);
                    int number = Integer.parseInt(commandList.get(2));
                    printFilterOfConditionsNumber(manipulationList, condition, number);
                    break;

            }

            input = scanner.nextLine();
        }


    }

    private static void printFilterOfConditionsNumber(List<Integer> manipulationList, String condition, int number) {
                switch (condition) {
            case ">":
                manipulationList.removeIf(integer -> integer <= number);
                break;
            case "<":
                manipulationList.removeIf(integer -> integer >= number);
                break;
            case "<=":
                manipulationList.removeIf(integer -> integer > number);
                break;
            case ">=":
                manipulationList.removeIf(integer -> integer < number);
                break;
        }
        System.out.println(manipulationList.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void getSumOfAllNumbers(List<Integer> numberList) {
        int sumOfNumbers = 0;
        for (int currentNumber : numberList) {
            sumOfNumbers += currentNumber;
        }
        System.out.println(sumOfNumbers);
    }

    private static void printEvenOddElements(List<Integer> numberList, String command) {
        switch (command) {
            case "even":
                numberList.removeIf(integer -> integer % 2 == 1);
                break;
            case "odd":
                numberList.removeIf(integer -> integer % 2 == 0);
                break;
        }
        System.out.println(numberList.toString().replaceAll("[\\[\\],]", ""));
    }
}
