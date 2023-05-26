package ShoppingSpree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputPerson = scanner.nextLine().split(";");

        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> productMap = new LinkedHashMap<>();

        for (int i = 0; i < inputPerson.length; i++) {
            String name = inputPerson[i].split("=")[0];
            double money = Double.parseDouble(inputPerson[i].split("=")[1]);

            try {
                Person person = new Person(name, money);
                people.put(name, person);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }
        }
        String[] products = scanner.nextLine().split(";");

        for (String currentProduct : products) {
            String productName = currentProduct.split("=")[0];
            double cost = Double.parseDouble(currentProduct.split("=")[1]);

            try {
                Product product = new Product(productName, cost);
                productMap.put(productName, product);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            String personName = command.split("\\s+")[0];
            String productName = command.split("\\s+")[1];

            Person buyer = people.get(personName);
            Product product = productMap.get(productName);

                try{
                    buyer.buyProduct(product);
                    System.out.printf("%s bought %s%n",personName,productName);
                }catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }


            command = scanner.nextLine();
        }

        people.values().forEach(System.out::println);


    }
}
