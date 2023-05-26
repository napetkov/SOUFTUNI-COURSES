package NestedLoops.MoreExercises;

import java.util.Scanner;

public class LettersCombinations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStart = scanner.nextLine();
        String inputEnd = scanner.nextLine();
        String inputSpecialLetter = scanner.nextLine();

        int start = inputStart.charAt(0);
        int end = inputEnd.charAt(0);
        int specialLetter = inputSpecialLetter.charAt(0);
        int counter = 0;
        for (int i = start; i <= end; i++) {
            if (i == specialLetter) {
                continue;
            }
            for (int j = start; j <= end; j++) {
                if (j == specialLetter) {
                    continue;
                }
                for (int k = start; k <= end; k++) {
                    if(k==specialLetter){
                        continue;
                    }
                    counter++;
                    System.out.printf("%c%c%c ", i, j, k);

                }

            }
        }
        System.out.println(counter);
    }
}
