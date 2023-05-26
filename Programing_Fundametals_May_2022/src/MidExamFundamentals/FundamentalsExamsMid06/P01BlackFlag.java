package MidExamFundamentals.FundamentalsExamsMid06;

import java.util.Scanner;

public class P01BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());

        double gainedPlunder = 0;

        for (int i = 1; i <= days; i++) {

            gainedPlunder += dailyPlunder;
            if (i % 3 == 0) {
                gainedPlunder += dailyPlunder * 1.00 / 2;
            }
            if (i % 5 == 0){

                gainedPlunder = gainedPlunder*0.70;
            }

        }
        if(gainedPlunder>=expectedPlunder){
            System.out.printf("Ahoy! %.2f plunder gained.",gainedPlunder);
        }else{
            System.out.printf("Collected only %.2f%% of the plunder.",(gainedPlunder/expectedPlunder)*100);
        }

    }
}
