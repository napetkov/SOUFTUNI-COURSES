package ExamsPractis;

import java.util.Scanner;

public class EasterCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int easternBread = Integer.parseInt(scanner.nextLine());
        int maxPoint = Integer.MIN_VALUE;
        String maxPointChef = "";
        for (int i = 0; i < easternBread; i++) {
            int counter = 0;
            int sumPoints = 0;

            String nameBaker = scanner.nextLine();
            String input = scanner.nextLine();
            while (!input.equals("Stop")) {
                int points = Integer.parseInt(input);
                counter++;
                sumPoints += points;

                input = scanner.nextLine();
            }
            System.out.printf("%s has %d points.%n",nameBaker,sumPoints);
            if(maxPoint<sumPoints){
                maxPoint = sumPoints;
                maxPointChef = nameBaker;
                System.out.printf("%s is the new number 1!%n",maxPointChef);
            }
        }
        System.out.printf("%s won competition with %d points!",maxPointChef,maxPoint);
    }
}
