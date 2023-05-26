package ConditionalStatementsAdvanced.Lab;

import java.util.Scanner;

public class SmallShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        String city = scanner.nextLine();
        double sum = Double.parseDouble(scanner.nextLine());
        double price = 0;
//        switch (city) {
//            case "Sofia":
//                switch (product) {
//                    case "coffee":
//                        System.out.println(sum * 0.50);
//                        break;
//                    case "water":
//                        System.out.println(sum * 0.80);
//                        break;
//                    case "beer":
//                        System.out.println(sum * 1.20);
//                        break;
//                    case "sweets":
//                        System.out.println(sum * 1.45);
//                        break;
//                    case "peanuts":
//                        System.out.println(sum * 1.60);
//                        break;
//                }
//                break;
//            case "Plovdiv":
//                switch (product) {
//                    case "coffee":
//                        System.out.println(sum * 0.40);
//                        break;
//                    case "water":
//                        System.out.println(sum * 0.70);
//                        break;
//                    case "beer":
//                        System.out.println(sum * 1.15);
//                        break;
//                    case "sweets":
//                        System.out.println(sum * 1.30);
//                        break;
//                    case "peanuts":
//                        System.out.println(sum * 1.50);
//                        break;
//                }
//                break;
//            case "Varna":
//                switch (product) {
//                    case "coffee":
//                        System.out.println(sum * 0.45);
//                        break;
//                    case "water":
//                        System.out.println(sum * 0.70);
//                        break;
//                    case "beer":
//                        System.out.println(sum * 1.10);
//                        break;
//                    case "sweets":
//                        System.out.println(sum * 1.35);
//                        break;
//                    case "peanuts":
//                        System.out.println(sum * 1.55);
//                        break;
//                }
//                break;
//        }

        if (city.equals("Sofia")) {
            switch (product) {
                case "coffee":
                    price = 0.50;
                    break;
                case "water":
                    price = 0.80;
                    break;
                case "beer":
                    price = 1.20;
                    break;
                case "sweets":
                    price = 1.45;
                    break;
                case "peanuts":
                    price = 1.60;
                    break;
            }
        } else if (city.equals("Plovdiv")) {
            switch (product) {
                case "coffee":
                    price = 0.40;
                    break;
                case "water":
                    price = 0.70;
                    break;
                case "beer":
                    price = 1.15;
                    break;
                case "sweets":
                    price = 1.30;
                    break;
                case "peanuts":
                    price = 1.50;
                    break;
            }
        } else if (city.equals("Varna")) {
            switch (product) {
                case "coffee":
                    price = 0.45;
                    break;
                case "water":
                    price = 0.70;
                    break;
                case "beer":
                    price = 1.10;
                    break;
                case "sweets":
                    price = 1.35;
                    break;
                case "peanuts":
                    price = 1.55;
                    break;
            }

        }
        System.out.println(sum * price);

    }
}
