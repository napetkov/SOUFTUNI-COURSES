package TextProcessing.Lab;

import java.util.Scanner;

public class P05DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder other = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
//            if ((symbol >= 'a' && symbol <= 'z') || (symbol >= 'A' && symbol <= 'Z')) {
//                letters.append(text.charAt(i));
//            } else if (symbol >= '0' && symbol <= '9') {
//                digits.append(text.charAt(i));
//            } else {
//                other.append(text.charAt(i));
//            }

            if(Character.isDigit(symbol)){
                digits.append(symbol);
            }else if(Character.isLetter(symbol)){
                letters.append(symbol);
            }else{
                other.append(symbol);
            }

        }
        System.out.println(digits.toString());
        System.out.println(letters.toString());
        System.out.println(other.toString());


    }
}
