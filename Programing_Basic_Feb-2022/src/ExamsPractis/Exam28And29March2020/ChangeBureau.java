package ExamsPractis.Exam28And29March2020;

import java.util.Scanner;

public class ChangeBureau {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bitcoins = Integer.parseInt(scanner.nextLine());
        double yuans = Double.parseDouble(scanner.nextLine());
        double commission = Double.parseDouble(scanner.nextLine());
        commission = commission/100;
        Double bitcoin = Double.valueOf(bitcoins);
        bitcoin = bitcoins * 1168.00 / 1.95;
        yuans = yuans*0.15*1.76/1.95;
        System.out.printf("%.2f",(bitcoin+yuans)-(bitcoin+yuans)*commission);


    }
}
