package RegularExpressions.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double totalPrice = 0;
        List<String> furnitureList = new ArrayList<>();
        while (!input.equals("Purchase")) {
            Pattern pattern = Pattern.compile(">>(?<furniture>\\w+)<<(?<price>[0-9]+.*[0-9]*)!(?<quantity>\\d+)");
            Matcher matcher = pattern.matcher(input);
            while(matcher.find()) {
                String furniture = matcher.group("furniture");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                totalPrice += price * quantity;
                furnitureList.add(furniture);
            }
            input = scanner.nextLine();
        }

        System.out.println("Bought furniture:");
        furnitureList.forEach(element-> System.out.println(element));
        System.out.printf("Total money spend: %.2f",totalPrice);

    }
}
