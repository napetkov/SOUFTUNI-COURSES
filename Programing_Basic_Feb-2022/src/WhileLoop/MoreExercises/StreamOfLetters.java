package WhileLoop.MoreExercises;

import java.util.Scanner;

public class StreamOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String output = "";
        int countC = 0;
        int countO = 0;
        int countN = 0;
        while (!input.equals("End")) {
            int letter = input.charAt(0);
//            if ((letter <= 'A' && letter >= 'Z') || (letter <= 'a' && letter >= 'z')) {
//                input = scanner.nextLine();
//                continue;
//            }
            if ((letter >= 'A' && letter <= 'Z') || (letter >= 'a' && letter <= 'z')) {
                if (input.equals("c")) {
                    countC++;
               //boolean flag - за всички c,n,o
                    if (countC == 1) {
                        input = "";
                    }
                } else if (input.equals("o")) {
                    countO++;
                    if (countO == 1) {
                        input = "";
                    }
                } else if (input.equals("n")) {
                    countN++;
                    if (countN == 1) {
                        input = "";
                    }
                }
                output += input;
                if (countC >= 1 && countN >= 1 && countO >= 1) {
                    System.out.printf("%s ", output);
                    output = "";
                    countC = 0;
                    countO = 0;
                    countN = 0;
                }
            }
            input = scanner.nextLine();
        }
    }
}
