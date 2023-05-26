import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        try{
            double sqrt = sqrt(input);
            System.out.printf("%.2f%n",sqrt);
        }catch (IllegalArgumentException ignored){
            System.out.println("Invalid");
        }

        System.out.println("Goodbye");

    }

    private static double sqrt(String input) {
        int number = Integer.parseInt(input);
        NegativeSQRTInputException exception = new NegativeSQRTInputException("Number "+number+" is negative");
        if(number<0){
            throw exception;
        }
        return Math.sqrt(number);
    }
}
