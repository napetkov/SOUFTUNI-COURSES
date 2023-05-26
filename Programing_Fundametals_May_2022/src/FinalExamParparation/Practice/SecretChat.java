package FinalExamParparation.Practice;

import java.util.Queue;
import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String concealedMassage = scanner.nextLine();

        StringBuilder updatedMassage = new StringBuilder(concealedMassage);

        String input = scanner.nextLine();
        while (!input.equals("Reveal")) {
            String[] commandLine = input.split(":\\|:");
            String command = commandLine[0];

            String substring = "";
            String currentMassage = "";
            switch (command) {
                //InsertSpace:|:{index}":
                case "InsertSpace":
                    int index = Integer.parseInt(commandLine[1]);
                    updatedMassage.insert(index, " ");
                    System.out.println(updatedMassage.toString());
                    break;
                //Reverse:|:{substring}
                case "Reverse":
                    substring = commandLine[1];
                    StringBuilder reversedSubstring = new StringBuilder(substring);


                    currentMassage = updatedMassage.toString();

                    if (currentMassage.contains(substring)) {
                        String replacedMassage = currentMassage.replaceFirst("\\Q"+substring+"\\E", "");
                        updatedMassage = new StringBuilder(replacedMassage);
                        updatedMassage.append(reversedSubstring.reverse());

                        System.out.println(updatedMassage.toString());
                    } else {
                        System.out.println("error");
                    }
                    break;
                //ChangeAll:|:{substring}:|:{replacement}
                case "ChangeAll":
                    substring = commandLine[1];
                    String replacement = commandLine[2];

                    currentMassage = updatedMassage.toString();
                    if(currentMassage.contains(substring)) {

                        currentMassage = currentMassage.replaceAll(substring, replacement);
                        updatedMassage = new StringBuilder(currentMassage);
                        System.out.println(updatedMassage.toString());
                    }else{
                        System.out.println("error");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s",updatedMassage.toString());

    }


}
