package MapsLambdaAndStreamAPI.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> productPrice = new LinkedHashMap<>();
        Map<String, Integer> productQuantity = new LinkedHashMap<>();

        String inputLine = scanner.nextLine();

        while (!inputLine.equals("buy")) {
            String[] productArr = inputLine.split(" ");

            String product = productArr[0];
            double price = Double.parseDouble(productArr[1]);
            int quantity = Integer.parseInt(productArr[2]);

            if (!productPrice.containsKey(product)) {
                productPrice.put(product, price);
                productQuantity.put(product, quantity);

            } else {
                Integer currentQuantity = productQuantity.get(product);
                productPrice.put(product, price);
                productQuantity.put(product, currentQuantity + quantity);
            }
            inputLine = scanner.nextLine();
        }

        productPrice.entrySet().forEach(element ->System.out.printf("%s -> %.2f%n",element.getKey(),
                (element.getValue()*productQuantity.get(element.getKey()))));
    }
}
