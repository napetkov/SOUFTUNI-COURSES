package ExamPerparation;

import java.util.Scanner;

public class MovieProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String movieName = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());
        int tickets = Integer.parseInt(scanner.nextLine());
        double priceTicket = Double.parseDouble(scanner.nextLine());
        int percentForCinema = Integer.parseInt(scanner.nextLine());
        double profit = days*tickets*priceTicket;
        profit =profit- profit*(percentForCinema/100.00);
        System.out.printf("The profit from the movie %s is %.2f lv.",movieName,profit);
    }
}
