package List.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int sizeList = numbersList.size();
        for (int i = 0; i < sizeList/ 2; i++) {
            numbersList.set(i, numbersList.get(i) + numbersList.get(numbersList.size()-1));
            numbersList.remove(numbersList.size()-1);

        }
        System.out.println(outputList(numbersList," "));
    //    System.out.println(numbersList.toString().replaceAll("[\\[\\],]",""));
    }

    public static String outputList(List<Integer> list, String delimiter) {
        String result = "";
        for (Integer num : list) {
            result += num + delimiter;
        }
        return result;

    }
}
