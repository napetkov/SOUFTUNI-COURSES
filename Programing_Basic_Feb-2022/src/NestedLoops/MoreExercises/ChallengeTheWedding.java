package NestedLoops.MoreExercises;

import java.util.Scanner;

public class ChallengeTheWedding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int men = Integer.parseInt(scanner.nextLine());
        int women = Integer.parseInt(scanner.nextLine());
        int tables = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        for (int i = 1; i <= men; i++) {
            for (int j = 1; j <= women; j++) {
                if (counter >= tables) {
                    break;
                }
                System.out.printf("(%d <-> %d) ", i, j);
                counter++;

            }

        }
    }
}
