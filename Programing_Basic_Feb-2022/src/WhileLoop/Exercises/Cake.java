package WhileLoop.Exercises;

import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int sizeCake = width * length;
        boolean isCakeOver = false;
        String input = scanner.nextLine();
        while (!input.equals("STOP")) {
            int pieces = Integer.parseInt(input);
            sizeCake -= pieces;
            if(sizeCake<=0){
                isCakeOver = true;
                break;
            }
            input = scanner.nextLine();
        }
        if(isCakeOver){
            System.out.printf("No more cake left! You need %d pieces more.",Math.abs(sizeCake));
        }else{
            System.out.printf("%d pieces are left.",sizeCake);
        }


    }
}
