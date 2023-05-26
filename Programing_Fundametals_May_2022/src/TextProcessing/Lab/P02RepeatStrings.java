package TextProcessing.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P02RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strArr = scanner.nextLine().split(" ");

        for (String text : strArr) {
            int len = text.length();
            System.out.print(repeatString(text,len));
        }

    }

    public static String repeatString(String s, int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += s;
        }
        return result;
    }
}
