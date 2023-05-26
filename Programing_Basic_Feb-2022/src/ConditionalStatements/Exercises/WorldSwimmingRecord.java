package ConditionalStatements.Exercises;

import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double wr = Double.parseDouble(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        double timeForMeter = Double.parseDouble(scanner.nextLine());

        double timePetter = distance * timeForMeter;
        timePetter = timePetter + (Math.floor(distance / 15)) * 12.5;
       // System.out.println(timePetter);
        double difference = Math.abs(wr - timePetter);
        if (timePetter < wr) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.",timePetter);
        }else{
            System.out.printf("No, he failed! He was %.2f seconds slower.",difference);
        }
    }

}
