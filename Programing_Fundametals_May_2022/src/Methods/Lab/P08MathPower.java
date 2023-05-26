package Methods.Lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P08MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number = Double.parseDouble(scanner.nextLine());
        int givenPower = Integer.parseInt(scanner.nextLine());
        double result = mathPower(number,givenPower);

        DecimalFormat df = new DecimalFormat("0.#####");
        System.out.println(df.format(result));

    }

    public static double mathPower(double number, int givenPower){
        return Math.pow(number,givenPower);

    }

}
