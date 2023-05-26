package TextProcessing.Exercises;

import java.util.Scanner;

public class P04CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String text = scanner.nextLine();

        StringBuilder encryptedText = new StringBuilder();
        for (char symbol:text.toCharArray()){
            symbol +=3;
            encryptedText.append(symbol);
        }
        System.out.println(encryptedText);
        

    }
}
