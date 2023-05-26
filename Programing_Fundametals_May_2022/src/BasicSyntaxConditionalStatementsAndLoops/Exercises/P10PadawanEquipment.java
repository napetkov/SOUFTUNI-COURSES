package BasicSyntaxConditionalStatementsAndLoops.Exercises;

import java.util.Scanner;

public class P10PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double amount = Double.parseDouble(scanner.nextLine());
        double countOfStudents = Integer.parseInt(scanner.nextLine());
        double priceLightsabers = Double.parseDouble(scanner.nextLine());
        double priceRobes = Double.parseDouble(scanner.nextLine());
        double priceBelts = Double.parseDouble(scanner.nextLine());
        double totalMoney = priceLightsabers * Math.ceil(countOfStudents * 1.10) + priceRobes * countOfStudents + priceBelts * Math.ceil(countOfStudents - (countOfStudents / 6));

        if(totalMoney<=amount){
            System.out.printf("The money is enough - it would cost %.2flv.",totalMoney);
        }else{
            System.out.printf("George Lucas will need %.2flv more.",totalMoney-amount);
        }

    }
}
