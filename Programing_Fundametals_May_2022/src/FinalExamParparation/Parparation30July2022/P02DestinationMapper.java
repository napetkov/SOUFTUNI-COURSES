package FinalExamParparation.Parparation30July2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("(=|\\/)(?<destination>[A-Z][A-Za-z]{2,})\\1");
        Matcher matchDestination = pattern.matcher(input);
        int travelPoints = 0;
        List<String> destinationList = new ArrayList<>();

        while(matchDestination.find()){
            destinationList.add(matchDestination.group("destination"));
            travelPoints+=matchDestination.group("destination").length();

        }
        System.out.println("Destinations: "+destinationList.toString().replaceAll("[\\[\\]]",""));
        System.out.println("Travel Points: "+travelPoints);

    }
}
