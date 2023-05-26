package ForLoops.Exercises;

import java.util.Scanner;

public class CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lilyAge = Integer.parseInt(scanner.nextLine());
        double washingMachine = Double.parseDouble(scanner.nextLine());
        int toyPrice = Integer.parseInt(scanner.nextLine());
        int sumMoney = 0;
        int toysNUm = 0;
        int brotherSum = 0;
        int totalSum = 0;
        for (int i = 1; i <= lilyAge; i++) {
            if (i % 2 == 0) {
                sumMoney += (i / 2) * 10;
                brotherSum += 1;
            } else {
                toysNUm += 1;
            }
            totalSum = sumMoney - brotherSum + toysNUm * toyPrice;

        }
        if(totalSum>=washingMachine){
            System.out.printf("Yes! %.2f",totalSum-washingMachine);
        }else{
            System.out.printf("No! %.2f",washingMachine-totalSum);
        }
    }
}
