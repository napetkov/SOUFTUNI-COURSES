package FinalExam07Aug2022;

import java.util.Scanner;

public class DecryptingCommands {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String encryptedMassage = scanner.nextLine();
        String input = scanner.nextLine();
        StringBuilder decryptedMassage = new StringBuilder();


        while (!input.equals("Finish")) {
            String[] commandLine = input.split(" ");
            String command = commandLine[0];

            switch (command) {
                case "Replace":
                    String currentChar = commandLine[1];
                    String newChar = commandLine[2];
                    encryptedMassage = encryptedMassage.replace(currentChar, newChar);
                    System.out.println(encryptedMassage);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(commandLine[1]);
                    int endIndex = Integer.parseInt(commandLine[2]);

                    if (isValidIndexes(encryptedMassage, startIndex, endIndex)) {
                        decryptedMassage = new StringBuilder(encryptedMassage);
                        decryptedMassage.delete(startIndex, endIndex+1);
                        encryptedMassage = decryptedMassage.toString();
                        System.out.println(encryptedMassage);

                    } else {
                        System.out.println("Invalid indices!");
                    }
                    break;

                case "Make":
                    String upperLower = commandLine[1];
                    if(upperLower.equals("Upper")){
                        encryptedMassage = encryptedMassage.toUpperCase();
                        System.out.println(encryptedMassage);
                    }else if(upperLower.equals("Lower")){
                        encryptedMassage = encryptedMassage.toLowerCase();
                        System.out.println(encryptedMassage);
                    }
                    break;

                    case "Check":
                    String substring = commandLine[1];
                    if(encryptedMassage.contains(substring)){
                        System.out.println("Message contains "+substring);
                    }else{
                        System.out.println("Message doesn't contain "+substring);
                    }
                    break;
                case "Sum":
                    startIndex = Integer.parseInt(commandLine[1]);
                    endIndex = Integer.parseInt(commandLine[2]);

                    if(isValidIndexes(encryptedMassage,startIndex,endIndex)) {
                        substring = encryptedMassage.substring(startIndex, endIndex+1);
                        int sum = 0;
                        for (int i = 0; i < substring.length(); i++) {
                            sum += substring.charAt(i);
                        }
                        System.out.println(sum);

                    }else{
                        System.out.println("Invalid indices!");
                    }
                    break;


            }


            input = scanner.nextLine();
        }


    }

    private static boolean isValidIndexes(String encryptedMassage, int startIndex, int endIndex) {
        return startIndex >= 0 && startIndex < encryptedMassage.length() && endIndex >= 0 && endIndex <= encryptedMassage.length();
    }
}
