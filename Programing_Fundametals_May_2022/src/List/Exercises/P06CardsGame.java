package List.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstDeskList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondDeskList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int counterFirst = 0;
        int counterSecond = 0;
        while (!firstDeskList.isEmpty()&&!secondDeskList.isEmpty()) {


            int firstHand = firstDeskList.get(0);
            int secondHand = secondDeskList.get(0);


            if (firstHand > secondHand) {
                firstDeskList.add(firstHand);
                firstDeskList.add(secondHand);
                firstDeskList.remove(0);
                secondDeskList.remove(0);
                counterFirst++;
            } else if (firstHand == secondHand) {
                firstDeskList.remove(0);
                secondDeskList.remove(0);

            } else if (secondHand > firstHand) {
                secondDeskList.add(secondHand);
                secondDeskList.add(firstHand);
                secondDeskList.remove(0);
                firstDeskList.remove(0);
                counterSecond++;
            }
        }
        int sumOfWinner = 0;
        //може и без каоунтър.празният лист сочи загубилият
        if (secondDeskList.isEmpty()) {
            for (int i = 0; i < firstDeskList.size(); i++) {
                sumOfWinner += firstDeskList.get(i);
            }
            System.out.printf("First player wins! Sum: %d",sumOfWinner);

            }else {
            for (int i = 0; i < secondDeskList.size(); i++) {
                sumOfWinner+=secondDeskList.get(i);
            }
            System.out.printf("Second player wins! Sum: %d",sumOfWinner);
        }
    }
}
