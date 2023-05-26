package TextProcessing.Lab;

import java.util.Scanner;

public class P03Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String removeText = scanner.nextLine();
        String text = scanner.nextLine();

        while (text.contains(removeText)) {//може цикълада се направии с indexOf==-1,като след всяка итерация се проверява с indexOf
            text = text.replaceAll(removeText, "");
        }

        System.out.println(text);

    }
}
