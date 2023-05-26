package ExamsPractis.Exam28And29March2020;

import java.util.Scanner;

public class MountainRun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double worldRecord = Double.parseDouble(scanner.nextLine());
        double destination = Double.parseDouble(scanner.nextLine());
        double secForMeter = Double.parseDouble(scanner.nextLine());
        double timeGeorgi = destination*secForMeter+(Math.floor(destination/50))*30;

        if(timeGeorgi<worldRecord){
            System.out.printf("Yes! The new record is %.2f seconds.",timeGeorgi);
        }else{
            System.out.printf("No! He was %.2f seconds slower.",timeGeorgi-worldRecord);
        }
    }
}
