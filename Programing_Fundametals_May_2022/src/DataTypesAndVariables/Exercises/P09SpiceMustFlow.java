package DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class P09SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startingYield = Integer.parseInt(scanner.nextLine());
        int counterDays = 0;
        int totalAmount = 0;
        boolean flag = false;
        while (startingYield >= 100) {
            totalAmount += (startingYield - 26);
            counterDays++;
            startingYield -= 10;
            flag = true;
        }
      if(flag){
          totalAmount -= 26;
      }
        System.out.println(counterDays);
        System.out.println(totalAmount);
    }

}
