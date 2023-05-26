package ExamsPractis.Exam18And19July2020;

import java.util.Scanner;

public class AgencyProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameAirline = scanner.nextLine();
        int adultTicket = Integer.parseInt(scanner.nextLine());
        int childrenTicket = Integer.parseInt(scanner.nextLine());
        double adultTicketPrice = Double.parseDouble(scanner.nextLine());
        double tax = Double.parseDouble(scanner.nextLine());

        double totalPrice = (adultTicket*(adultTicketPrice+tax)+ childrenTicket*(adultTicketPrice-adultTicketPrice*0.7+tax))*0.20;
        System.out.printf("The profit of your agency from %s tickets is %.2f lv.",nameAirline,totalPrice);


    }
}
