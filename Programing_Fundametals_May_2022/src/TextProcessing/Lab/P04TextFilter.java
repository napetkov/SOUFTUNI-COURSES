package TextProcessing.Lab;

import java.util.Scanner;

public class P04TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String word : bannedWords) {
//            int length = word.length();
//            String asterisks = "";
//            for (int i = 0; i < length; i++) {
//                asterisks = asterisks.concat("*");
//            }
            text = text.replace(word,repeat("*",word.length()));
        }
        System.out.println(text);

    }
    public static String repeat(String s,int count){
       String result = "";
        for (int i = 0; i < count; i++) {
            result = result.concat(s);
        }
        return result;
    }
}
