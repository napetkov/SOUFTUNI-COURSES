package ExamsPractis.Exam9and10March2019;

import java.util.Scanner;

public class TennisEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double tennisRacketPrice = Double.parseDouble(scanner.nextLine());
        int numberTennisRacket = Integer.parseInt(scanner.nextLine());
        int tennisSneakers = Integer.parseInt(scanner.nextLine());


        double sneakersPrice = tennisRacketPrice/6;
        double totalMoney =tennisRacketPrice*numberTennisRacket+tennisSneakers*sneakersPrice;
        totalMoney = totalMoney*1.20;

        System.out.printf("Price to be paid by Djokovic %.0f%n",Math.floor(totalMoney/8));
        System.out.printf("Price to be paid by sponsors %.0f",Math.ceil((totalMoney/8)*7));

    }
}
