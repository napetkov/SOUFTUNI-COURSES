package MidExamFundamentals.FundamentalsExamsMid01;

import java.util.Arrays;
import java.util.Scanner;

public class P02TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int waitingPeople = Integer.parseInt(scanner.nextLine());
        int[] liftArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < liftArray.length; i++) {
            int element = liftArray[i];

            for (int j = 0; j < 4 - element; j++) {
                if (waitingPeople <= 0) {
                    break;
                }
                liftArray[i]++;
                waitingPeople--;
            }

        }

        if (isEmptySpots(liftArray)) {
            System.out.println("The lift has empty spots!");

        } else if (waitingPeople > 0) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", waitingPeople);
        }

        System.out.println(Arrays.toString(liftArray).replaceAll("[\\[\\],]", ""));


    }

    private static boolean isEmptySpots(int[] liftArray) {
        boolean isEmptySpots = false;
        for (int currentElement : liftArray) {
            if (currentElement < 4) {
                isEmptySpots = true;
                break;
            }
        }
        return isEmptySpots;
    }
}
