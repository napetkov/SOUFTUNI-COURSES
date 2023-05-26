package Exam26March2022;

import java.util.Scanner;

public class ANDProcessors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int processors = Integer.parseInt(scanner.nextLine());
        int employees = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());

        double producedProcessors = Math.floor(employees*8*days/3.00);
        if(processors>producedProcessors){
            System.out.printf("Losses: -> %.2f BGN",(processors-producedProcessors)*110.10);
        }else{
            System.out.printf("Profit: -> %.2f BGN",(producedProcessors-processors)*110.10);
        }



    }
}
