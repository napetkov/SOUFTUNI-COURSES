package MidExamFundamentals.FundametnalsExamsMid04;

import java.util.Arrays;
import java.util.Scanner;

public class P03HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] housesArray = Arrays.stream(scanner.nextLine().split("@"))
                .mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();
        int index = 0;
        while (!input.equals("Love!")) {

            String[] commandLine = input.split(" ");
            int indexToJump = Integer.parseInt(commandLine[1]);
            index += indexToJump;

            if (index >= housesArray.length) {
                index = 0;
            }

            if (housesArray[index] <= 0) {
                System.out.printf("Place %d already had Valentine's day.%n", index);
            } else {
                housesArray[index] -= 2;
                if (housesArray[index] <= 0) {
                    System.out.printf("Place %d has Valentine's day.%n", index);
                }
            }
            input = scanner.nextLine();
        }
        System.out.printf("Cupid's last position was %d.%n", index);
        int countNoValentinesDayHouse = 0;

        for (int currentElement : housesArray) {
            if (currentElement > 0) {
                countNoValentinesDayHouse++;
            }
        }
        if (countNoValentinesDayHouse == 0) {
            System.out.printf("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", countNoValentinesDayHouse);
        }


    }
}
