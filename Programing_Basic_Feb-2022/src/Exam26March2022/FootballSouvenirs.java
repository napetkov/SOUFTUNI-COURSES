package Exam26March2022;

import java.util.Scanner;

public class FootballSouvenirs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String team = scanner.nextLine();
        String souvenirs = scanner.nextLine();
        int numbersSouvenirs = Integer.parseInt(scanner.nextLine());
        double price = 0;
        boolean flag = true;
        switch (team) {
            case "Argentina":
                switch (souvenirs) {
                    case "flags":
                        price = 3.25;
                        break;
                    case "caps":
                        price = 7.20;
                        break;
                    case "posters":
                        price = 5.10;
                        break;
                    case "stickers":
                        price = 1.25;
                        break;
                    default:
                        flag =false;
                        System.out.println("Invalid stock!");
                }
                break;
            case "Brazil":
                switch (souvenirs) {
                    case "flags":
                        price = 4.20;
                        break;
                    case "caps":
                        price = 8.50;
                        break;
                    case "posters":
                        price = 5.35;
                        break;
                    case "stickers":
                        price = 1.20;
                        break;
                    default:
                        flag =false;
                        System.out.println("Invalid stock!");
                }
                break;
            case "Croatia":
                switch (souvenirs) {
                    case "flags":
                        price = 2.75;
                        break;
                    case "caps":
                        price = 6.90;
                        break;
                    case "posters":
                        price = 4.95;
                        break;
                    case "stickers":
                        price = 1.10;
                        break;
                    default:
                        System.out.println("Invalid stock!");
                }
                break;
            case "Denmark":
                switch (souvenirs) {
                    case "flags":
                        price = 3.10;
                        break;
                    case "caps":
                        price = 6.50;
                        break;
                    case "posters":
                        price = 4.80;
                        break;
                    case "stickers":
                        price = 0.90;
                        break;
                    default:
                        flag =false;
                        System.out.println("Invalid stock!");
                }
                break;
            default:
                flag = false;
                System.out.println("Invalid country!");
        }
        if(flag){
            System.out.printf("Pepi bought %d %s of %s for %.2f lv.",numbersSouvenirs,souvenirs,team,numbersSouvenirs*price);
        }


    }
}
