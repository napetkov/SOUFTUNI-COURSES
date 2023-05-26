package OtherPractis;

import java.util.Scanner;

public class SeriesOfSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String symbol = scanner.next();
        int countNumbers = 0;
        int countLetter = 0;
        for (int i = 0; i < symbol.length(); i++) {
            char newSymbol = symbol.charAt(i);
            if (newSymbol >= '0' && newSymbol <= '9') {
                countNumbers++;
            } else if ((newSymbol >= 'A' && newSymbol <= 'Z') || (newSymbol >= 'a' && newSymbol <= 'z')) {
                countLetter++;
            }
        }

        System.out.println(countNumbers);
        System.out.println(countLetter);
        System.out.println(countNumbers + countLetter);

    }
}
