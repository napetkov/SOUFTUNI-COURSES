package List.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            List<String> inputList = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            String command = inputList.get(0);
            switch (command) {
                case "Add":
                    numbersList.add(inputList.get(1));
                    break;
                case "Remove":
               numbersList.remove(inputList.get(1));
                      break;
                case "RemoveAt":
                    int index = Integer.parseInt(inputList.get(1));
                    numbersList.remove(index);
                    break;
                case "Insert":
                    index = Integer.parseInt(inputList.get(2));
                    numbersList.add(index,inputList.get(1));
                    break;

            }
            input = scanner.nextLine();
        }

        System.out.println(numbersList.toString().replaceAll("[\\[\\],]",""));
    }
}
