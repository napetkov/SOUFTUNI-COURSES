package FinalExamParparation.Practice;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String massage = scanner.nextLine();
        StringBuilder updatedMassage = new StringBuilder(massage);

        String input = scanner.nextLine();

        while (!input.equals("Decode")) {
            String[] commandLine = input.split("\\|");
            String command = commandLine[0];

            switch (command) {
                case "Move":
                    int numberOfLetters = Integer.parseInt(commandLine[1]);

                    for (int i = 0; i < numberOfLetters; i++) {
                        char firstLetter = updatedMassage.charAt(0);
                        updatedMassage.delete(0,1);
                        updatedMassage.append(firstLetter);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(commandLine[1]);
                    String value = commandLine[2];

                    updatedMassage.insert(index,value);
                    break;
                case "ChangeAll":
                    String substring = commandLine[1];
                    String replacement = commandLine[2];
                    String replacedMassage = updatedMassage.toString();

                    replacedMassage = replacedMassage.replace(substring,replacement);
                    updatedMassage = new StringBuilder(replacedMassage);
                    break;
            }
            input = scanner.nextLine();
        }

        System.out.printf("The decrypted message is: %s",updatedMassage.toString());
    }
}
