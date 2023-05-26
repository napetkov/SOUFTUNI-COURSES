package ConditionalStatements.Lab;

import java.util.Scanner;

public class ExcellentResult_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int grade =Integer.parseInt(scanner.nextLine());

        boolean isExcellent = grade >= 5;

        if(grade >= 5){
            System.out.println("Excellent!");

        }


    }

}
