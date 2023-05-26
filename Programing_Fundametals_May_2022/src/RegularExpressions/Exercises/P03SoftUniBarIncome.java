package RegularExpressions.Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double income = 0;
        while (!input.equals("end of shift")) {
            double totalPrice = 0;

            Pattern pattern = Pattern.compile("([^|$%.]*)%(?<customerName>[A-z][a-z]+)%([^|$%.]*)<(?<product>\\w+)>([^|$%.]*)\\|(?<quantity>\\d+)\\|([^|$%.0-9]*)(?<price>\\d+.?\\d*)[$]");
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                totalPrice = price * quantity;

                System.out.printf("%s: %s - %.2f%n", matcher.group("customerName"), matcher.group("product"), totalPrice);

            }
            income += totalPrice;
            input = scanner.nextLine();
        }

        System.out.printf("Total income: %.2f", income);
    }
}
