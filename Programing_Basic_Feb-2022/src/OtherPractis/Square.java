package OtherPractis;

import java.util.Scanner;

public class Square {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        //за правоъгълник
        //int width = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.printf("#");

            }
            System.out.println();
        }


    }
}
