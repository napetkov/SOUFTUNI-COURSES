package TextProcessing.MoreExercises;

import java.util.Scanner;

public class P01ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String input = scanner.nextLine();

            int firstIndexOfName = input.indexOf("@");
            int secondIndexOfName = input.indexOf("|");
            int firstIndexOfAge = input.indexOf("#");
            int secondIndexOfAge = input.indexOf("*");

            String name = input.substring(firstIndexOfName+1,secondIndexOfName);
            String age = input.substring(firstIndexOfAge+1,secondIndexOfAge);

            System.out.printf("%s is %s years old.%n",name,age);
        }




    }
}
