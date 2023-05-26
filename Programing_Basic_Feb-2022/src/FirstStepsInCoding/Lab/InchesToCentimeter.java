package FirstStepsInCoding.Lab;

import java.util.Scanner;

public class InchesToCentimeter {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double inches=Double.parseDouble(scanner.next());
        double result = inches * 2.54;
        System.out.println(result);
    }
}
