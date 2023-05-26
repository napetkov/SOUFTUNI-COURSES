package ConditionalStatementsAdvanced.MoreExercises;

import java.util.Scanner;

public class MultiplyBy2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            double num = Double.parseDouble(scanner.nextLine());
            if(num>=0){
                System.out.printf("Result: %.2f%n",num*2);
            }else{
                System.out.printf("Negative number!");
                break;
            }

        }
    }
}
