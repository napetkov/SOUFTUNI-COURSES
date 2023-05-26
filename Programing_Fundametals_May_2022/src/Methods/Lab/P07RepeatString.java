package Methods.Lab;

import java.util.Scanner;

public class P07RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();
        int repeatCounter = Integer.parseInt(scanner.nextLine());
        String resultString = repeatedString(repeatCounter,inputString);
        System.out.println(resultString);

    }

    public static String repeatedString(int n, String inputString) {
        String newString = "";
        for (int i = 0; i < n; i++) {
            newString += inputString;
        }
        return newString;
    }
}
