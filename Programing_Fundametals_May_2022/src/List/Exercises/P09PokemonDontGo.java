package List.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numberList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int sumOfRemovedElements = 0;
        while (!numberList.isEmpty()) {
            int index = Integer.parseInt(scanner.nextLine());
            int removedElement = 0;
            if (index < 0) {
                removedElement = numberList.get(0);
                numberList.set(0, numberList.get(numberList.size() - 1));

            } else if (index >= numberList.size()) {
                removedElement = numberList.get(numberList.size() - 1);
                numberList.set(numberList.size() - 1, numberList.get(0));

            } else {
                removedElement = numberList.get(index);
                numberList.remove(index);
            }

            sumOfRemovedElements += removedElement;

            for (int i = 0; i < numberList.size(); i++) {

                if (numberList.get(i) <= removedElement) {
                    int value = numberList.get(i) + removedElement;
                    numberList.set(i, value);
                } else {
                    int value = numberList.get(i) - removedElement;
                    numberList.set(i, value);
                }

            }

        }
        System.out.println(sumOfRemovedElements);
    }
}
