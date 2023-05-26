package List.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numberList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            List<String> inputList = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            String command = inputList.get(0);
            int element = Integer.parseInt(inputList.get(1));
            switch (command) {
                case "Delete":
                    deleteAlLEqualsElements(numberList,element);
                    break;
                case "Insert":
                    int insertIndex = Integer.parseInt(inputList.get(2));
                    insertElementToCurrentIndex(numberList,element,insertIndex);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println(numberList.toString().replaceAll("[\\[\\],]",""));
    }

    private static List insertElementToCurrentIndex(List<Integer> numberList, int element, int insertIndex) {

        numberList.add(insertIndex,element);
    return numberList;
    }

    private static List deleteAlLEqualsElements(List<Integer> numberList, int element) {
        numberList.removeIf(integer -> integer==element);
        //numberList.removeAll(Arrays.asList(element)); - командата е същата,но таботи с колекции-лист;
        return numberList;
    }
}
