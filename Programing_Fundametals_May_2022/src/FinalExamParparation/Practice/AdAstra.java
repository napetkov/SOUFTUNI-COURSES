package FinalExamParparation.Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("(#|\\|)(?<itemName>[A-Za-z ]+)\\1(?<date>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\d{1,5})\\1");
        Matcher matcher = pattern.matcher(input);
        List<String> itemsList = new ArrayList<>();

        int totalCalories = 0;
        while (matcher.find()) {
            String itemName = matcher.group("itemName");
            String date = matcher.group("date");
            int calories = Integer.parseInt(matcher.group("calories"));
            totalCalories += calories;

            String item = "Item: " + itemName + ", Best before: " + date + ", Nutrition: " + calories;
            itemsList.add(item);

        }
        System.out.printf("You have food to last you for: %d days!%n", totalCalories / 2000);

        if (!itemsList.isEmpty()) {
            itemsList.forEach(element -> System.out.println(element));
        }


    }
}
