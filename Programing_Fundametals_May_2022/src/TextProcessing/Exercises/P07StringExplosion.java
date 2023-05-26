package TextProcessing.Exercises;

import java.util.Scanner;

public class P07StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder text = new StringBuilder(input);
        int totalStrength = 0;
        for (int i = 0; i < text.length(); i++) {
            char symbol = (char) text.charAt(i);

            if (symbol == '>' && i != text.length() - 1) {
                int attackStrength = Integer.parseInt(text.charAt(i + 1) + "");
                totalStrength += attackStrength;

            }else if(symbol!='>'&&totalStrength>0){
                text.deleteCharAt(i);
                totalStrength--;
                i--;
            }
        }
        System.out.println(text);

    }
}
