package FinalExamParparation.Parparation30July2022;

import java.util.Locale;
import java.util.Scanner;

public class P01ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rawActivationKey = scanner.nextLine();
        String commandLine = scanner.nextLine();

        while (!commandLine.equals("Generate")) {
            String command = commandLine.split(">>>")[0];
            String substring = "";
            int startIndex = 0;
            int endIndex = 0;

            switch (command) {
                case "Contains":
                    substring = commandLine.split(">>>")[1];

                    if (rawActivationKey.contains(substring)) {
                        System.out.printf("%s contains %s%n", rawActivationKey, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;

                case "Flip":
                    startIndex = Integer.parseInt(commandLine.split(">>>")[2]);
                    endIndex = Integer.parseInt(commandLine.split(">>>")[3]);

                    substring = rawActivationKey.substring(startIndex, endIndex);

                    String upperLower = commandLine.split(">>>")[1];

                    if (upperLower.equals("Upper")) {
                        rawActivationKey = rawActivationKey.replace(substring, substring.toUpperCase());

                    } else if (upperLower.equals("Lower")) {
                        rawActivationKey = rawActivationKey.replace(substring, substring.toLowerCase());

                    }
                    System.out.println(rawActivationKey);
                    break;
                case "Slice":
                    startIndex = Integer.parseInt(commandLine.split(">>>")[1]);
                    endIndex = Integer.parseInt(commandLine.split(">>>")[2]);

                    substring = rawActivationKey.substring(startIndex, endIndex);

                    rawActivationKey = rawActivationKey.replace(substring, "");

                    System.out.println(rawActivationKey);

                    break;
            }


            commandLine = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s", rawActivationKey);

    }
}
