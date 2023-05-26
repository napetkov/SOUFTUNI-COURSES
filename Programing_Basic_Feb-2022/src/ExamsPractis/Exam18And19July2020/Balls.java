package ExamsPractis.Exam18And19July2020;

import java.util.Scanner;

public class Balls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int totalPoints = 0;
        int countRedBalls = 0;
        int countOrangeBalls = 0;
        int countYellowBalls = 0;
        int countWhiteBalls = 0;
        int countBlackBalls = 0;
        int countOtherBalls = 0;

        for (int i = 0; i < n; i++) {
            String colors = scanner.nextLine();
            switch (colors){
                case "red":
                    totalPoints+=5;
                    countRedBalls++;
                    break;
                case "orange":
                    totalPoints+=10;
                    countOrangeBalls++;
                    break;
                case "yellow":
                    totalPoints+=15;
                    countYellowBalls++;
                    break;
                case "white":
                    totalPoints+=20;
                    countWhiteBalls++;
                    break;
                case "black":
                    totalPoints = totalPoints/2;
                    countBlackBalls++;
                    break;
                default:
                    countOtherBalls++;
            }

        }
        System.out.printf("Total points: %d%n",totalPoints);
        System.out.printf("Red balls: %d%n",countRedBalls);
        System.out.printf("Orange balls: %d%n", countOrangeBalls);
        System.out.printf("Yellow balls: %d%n", countYellowBalls);
        System.out.printf("White balls: %d%n", countWhiteBalls);
        System.out.printf("Other colors picked: %d%n", countOtherBalls);
        System.out.printf("Divides from black balls: %d", countBlackBalls);

    }
}

