package FinalExamParparation.Parparation27July2022;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stops = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("Travel")) {
            String[] commandLine = input.split(":");
            String command = commandLine[0];
            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(commandLine[1]);
                    String currentStop = commandLine[2];
                    if (isValidIndex(stops, index)){
                        stops.insert(index,currentStop);
                    }
                    System.out.println(stops.toString());
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(commandLine[1]);
                    int endIndex = Integer.parseInt(commandLine[2]);

                    if(isValidIndex(stops,startIndex)&&isValidIndex(stops,endIndex)){
                        stops.delete(startIndex,endIndex+1);
                    }
                    System.out.println(stops.toString());
                    break;
                case "Switch":
                    String oldString = commandLine[1];
                    String newString = commandLine[2];
                    int indexOfOldString = stops.indexOf(oldString);
                    if(stops.toString().contains(oldString)){
                        String updatedText = stops.toString().replace(oldString,newString);
                        stops = new StringBuilder(updatedText);
                    }


                    System.out.println(stops.toString());

                    break;
            }


            input = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: "+stops);

    }

    private static boolean isValidIndex(StringBuilder stops, int index) {

        return index >= 0 && index < stops.length();
    }
}
