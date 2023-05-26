package OtherPractis;

import java.util.Scanner;

public class TheMostPowerfulWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
String maxWord = "";
double maxPoints = Integer.MIN_VALUE;
        String word = scanner.nextLine();
        while (!word.equals("End of words")) {
            double sumOfLetters = 0;
            for (int i = 0; i < word.length(); i++) {
                sumOfLetters += word.charAt(i);
            }

            if (word.charAt(0) == 'a' || word.charAt(0) == 'A' || word.charAt(0) == 'e' || word.charAt(0) == 'E' || word.charAt(0) == 'i' || word.charAt(0) == 'I' || word.charAt(0) == 'o' || word.charAt(0) == 'O' || word.charAt(0) == 'u' || word.charAt(0) == 'U' || word.charAt(0) == 'y' || word.charAt(0) == 'Y') {
                sumOfLetters = sumOfLetters * word.length();
            } else {
                sumOfLetters = Math.round(sumOfLetters/word.length());
            }
            if(sumOfLetters>maxPoints){
                maxPoints = sumOfLetters;
                maxWord = word;
            }
            word = scanner.nextLine();
        }
        System.out.printf("The most powerful word is %s - %.0f",maxWord,maxPoints);

    }
}
