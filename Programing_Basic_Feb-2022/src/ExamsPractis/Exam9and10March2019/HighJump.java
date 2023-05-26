package ExamsPractis.Exam9and10March2019;

import java.util.Scanner;

public class HighJump {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = Integer.parseInt(scanner.nextLine());
        int neededHeight = height - 30;
        int counterJumps = 0;
        int counterUnsuccessful = 0;
        boolean flag = false;
        for (int i = neededHeight; i <= height; i += 5) {
            int input = Integer.parseInt(scanner.nextLine());
            counterJumps++;
            while (input <= i) {
                counterUnsuccessful++;
                if (counterUnsuccessful == 3) {
                    flag = true;
                    System.out.printf("Tihomir failed at %dcm after %d jumps.", i, counterJumps);
                    break;
                }
                input = Integer.parseInt(scanner.nextLine());
                counterJumps++;
            }
            counterUnsuccessful = 0;
            if(flag){
                break;
            }
        }
        if (!flag) {
            System.out.printf("Tihomir succeeded, he jumped over %dcm after %d jumps.", height, counterJumps);
        }

    }
}

