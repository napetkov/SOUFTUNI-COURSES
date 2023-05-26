package MidExamFundamentals.MidExam26July;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02CoffeeLover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> coffeeList = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String[] commandLine = scanner.nextLine().split(" ");
            String command = commandLine[0];

            switch (command) {
                case "Include":
                    String element = commandLine[1];
                    coffeeList.add(element);
                    break;
                case "Remove":
                    String secondCommand = commandLine[1];
                    int removeCount = Integer.parseInt(commandLine[2]);

                    if (isValidRemoveIndex(coffeeList, removeCount)) {

                        switch (secondCommand) {
                            case "first":

                                for (int j = 0; j < removeCount; j++) {
                                    coffeeList.remove(0);
                                }
                                break;
                            case "last":
                                for (int j = 0; j < removeCount; j++) {
                                    coffeeList.remove(coffeeList.size() - 1);
                                }
                                break;
                        }

                    }
                    break;
                case "Prefer":
                    int preferIndex1 = Integer.parseInt(commandLine[1]);
                    int preferIndex2 = Integer.parseInt(commandLine[2]);

                    if (isValidPreferIndex(coffeeList, preferIndex1, preferIndex2)) {
                        String elementOnIndex1 = coffeeList.get(preferIndex1);
                        coffeeList.set(preferIndex1,coffeeList.get(preferIndex2));
                        coffeeList.set(preferIndex2,elementOnIndex1);
                    }
                    break;
                case "Reverse":
                    Collections.reverse(coffeeList);
                    break;
            }
        }
        System.out.println("Coffees:");
        System.out.println(coffeeList.toString().replaceAll("[\\[\\],]",""));

    }

    private static boolean isValidPreferIndex(List<String> coffeeList, int preferIndex1, int preferIndex2) {
        return preferIndex1 >= 0 && preferIndex1 < coffeeList.size() && preferIndex2 >= 0 && preferIndex2 < coffeeList.size() && preferIndex1 != preferIndex2;
    }

    private static boolean isValidRemoveIndex(List<String> coffeeList, int removeCount) {
        return removeCount >= 0 && removeCount <= coffeeList.size();
    }
}
