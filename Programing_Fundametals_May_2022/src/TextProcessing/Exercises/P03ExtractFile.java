package TextProcessing.Exercises;

import java.util.Scanner;

public class P03ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int indexOfName = input.lastIndexOf("\\");
        int indexOfExtension = input.lastIndexOf(".");
        String name = input.substring(indexOfName+1,indexOfExtension);
        String extension = input.substring(indexOfExtension+1);

        System.out.printf("File name: %s%n",name);
        System.out.printf("File extension: %s",extension);
    }
}
