package List.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numberList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String inputLine = scanner.nextLine();

        while (!inputLine.equals("End")) {
            List<String> inputList = Arrays.stream(inputLine.split(" "))
                    .collect(Collectors.toList());

            String command = inputList.get(0);
            int index = 0;
            int element = 0;
            switch (command) {
                case "Add":
                    element = Integer.parseInt(inputList.get(1));
                    numberList.add(element);
                    break;
                case "Insert":
                    index = Integer.parseInt(inputList.get(2));
                    element = Integer.parseInt(inputList.get(1));

                    if (isNotValidIndex(numberList.size(), index)) {
                        System.out.println("Invalid index");
                        break;
                    }

                    numberList.add(index, element);
                    break;
                case "Remove":
                    index = Integer.parseInt(inputList.get(1));

                    if (isNotValidIndex(numberList.size(), index)) {
                        System.out.println("Invalid index");
                        break;
                    }

                    numberList.remove(index);
                    break;
                case "Shift":
                    String secondCommand = inputList.get(1);
                    int count = Integer.parseInt(inputList.get(2));
                    if(count < 0){
                        System.out.println("Invalid index");
                        break;
                    }

                    shiftLeftRight(numberList, secondCommand, count);
                    break;
            }
            inputLine = scanner.nextLine();
        }
        System.out.println(numberList.toString().replaceAll("[\\[\\],]", ""));
    }

    private static boolean isNotValidIndex(int size, int index) {
        return size <= index || index < 0;
    }

    private static List shiftLeftRight(List<Integer> numberList, String secondCommand, int count) {
        switch (secondCommand) {
            case "right":
                for (int i = 0; i < count; i++) {
                    numberList.add(0, numberList.get(numberList.size() - 1));
                    numberList.remove(numberList.size() - 1);
                }
                break;
            case "left":
                for (int i = 0; i < count; i++) {
                    numberList.add(numberList.get(0));
                    numberList.remove(0);
                }
                break;
        }
        return numberList;
    }
}
