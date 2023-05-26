package ForLoops.Exercises;

import java.util.Scanner;

public class TennisRanklist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTours= Integer.parseInt(scanner.nextLine());
        int rankingPoints = Integer.parseInt(scanner.nextLine());
       double points = rankingPoints;
       double sumWon = 0;
        for (int i = 0; i < numTours; i++) {
            String stage = scanner.nextLine();
            switch (stage){
                case "W":
                    points += 2000;
                    sumWon +=1;
                    break;
                case "F":
                    points += 1200;
                    break;
                case "SF":
                    points+=720;
                    break;
            }

        }
        System.out.printf("Final points: %.0f%n",points);
        System.out.printf("Average points: %.0f%n",Math.floor((points-rankingPoints)/numTours));
        System.out.printf("%.2f%%",sumWon/numTours*100);
    }
}
