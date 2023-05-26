package SetsAndMapsAdvanced.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> sortedList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted((n1,n2)->n2.compareTo(n1))
                .collect(Collectors.toList());
        int counter = 0;

        for (int i = 0; i < sortedList.size(); i++) {
            System.out.print(sortedList.get(i)+" ");
            counter++;
            if(counter==3){
                break;
            }
        }
    }
}
