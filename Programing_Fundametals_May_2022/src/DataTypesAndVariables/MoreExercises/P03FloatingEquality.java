package DataTypesAndVariables.MoreExercises;

import java.math.BigDecimal;
import java.util.Scanner;

public class P03FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double numberOne = Double.parseDouble(scanner.nextLine());
        numberOne = numberOne*1000000;
        double numberTwo = Double.parseDouble(scanner.nextLine());
        numberTwo = numberTwo*1000000;
        double eps = 0.000001;
        eps = eps*1000000;
        double difference = Math.abs(numberOne-numberTwo);
        if(difference<eps){
            System.out.println("True");
        }else{
            System.out.println("False");
        }

    }
}
