package FinalExamParparation.Practice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            Pattern validBarcode = Pattern.compile("(@#+)(?<barcode>[A-Z][A-Za-z0-9]{4,}[A-Z])(@#+)");
            Matcher matchBarcode = validBarcode.matcher(input);
            if (matchBarcode.find()) {
                String barcode = matchBarcode.group("barcode");
                Pattern digits = Pattern.compile("[0-9]");
                Matcher matchDigits = digits.matcher(barcode);
                StringBuilder productGroup = new StringBuilder();
                while (matchDigits.find()) {
                    productGroup.append(matchDigits.group());
                }
                if (productGroup.length()==0) {
                    productGroup.append("00");
                }
                System.out.println("Product group: " + productGroup.toString());
            } else {
                System.out.println("Invalid barcode");
            }
        }


    }
}
