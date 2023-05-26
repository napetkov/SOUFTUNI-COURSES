package StramFilesAndDirectories.Exercises;

import java.io.*;

public class P04CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("Exercises-Resources/input.txt"));

        PrintWriter printWriter = new PrintWriter(new FileWriter("Exercises-Resources/output.txt"));

        int bytes = bufferedReader.read();

        int countVowels = 0;
        int countConsonants = 0;
        int countPunctuationsMark = 0;


        while (bytes != -1) {
            char symbol = (char) bytes;

            if (isVowels(symbol)) {
                countVowels++;

            } else if (isPunctuationMark(symbol)) {
                countPunctuationsMark++;

            } else if (!Character.isWhitespace(symbol)) {
                countConsonants++;

            }

            bytes = bufferedReader.read();
        }
        bufferedReader.close();

        printWriter.println("Vowels: " + countVowels);
        printWriter.println("Consonants: " + countConsonants);
        printWriter.println("Punctuation: " + countPunctuationsMark);

        printWriter.close();
    }

    private static boolean isPunctuationMark(char symbol) {
        return symbol == '!' || symbol == ',' || symbol == '.' || symbol == '?';
    }

    private static boolean isVowels(char symbol) {
        return symbol == 'a' || symbol == 'e' || symbol == 'o' || symbol == 'u' || symbol == 'i';
    }
}
