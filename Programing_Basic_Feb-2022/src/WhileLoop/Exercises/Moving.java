package WhileLoop.Exercises;

import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int high = Integer.parseInt(scanner.nextLine());
        int allVolume = width * length * high;
        boolean isFull = false;
        String input = scanner.nextLine();
        while (!input.equals("Done")) {
            int numberOfBoxes = Integer.parseInt(input);
            allVolume -= numberOfBoxes;
            if (allVolume <= 0) {
                isFull = true;
                break;
            }
            input = scanner.nextLine();
        }
        if(isFull){
            System.out.printf("No more free space! You need %d Cubic meters more.",Math.abs(allVolume));
        }else{
            System.out.printf("%d Cubic meters left.",Math.abs(allVolume));
        }
    }
}
