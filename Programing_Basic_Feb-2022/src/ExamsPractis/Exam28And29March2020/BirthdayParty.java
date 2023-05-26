package ExamsPractis.Exam28And29March2020;

import java.util.Scanner;

public class BirthdayParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double rent = Double.parseDouble(scanner.nextLine());
        double cake = rent*0.20;
        double drinks = cake - cake*0.45;
        double animator = rent/3;
        System.out.println(rent+cake+drinks+animator);
    }
}
