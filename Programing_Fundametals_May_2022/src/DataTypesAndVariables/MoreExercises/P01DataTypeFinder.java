package DataTypesAndVariables.MoreExercises;

import java.util.Scanner;

public class P01DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            String input = "";
        while (!input.equals("END")) {
            if(scanner.hasNextBoolean()){
                System.out.println("boolean");
            }else if(scanner.hasNextDouble()){
                System.out.println("double");
            }else if(scanner.hasNextInt()){
                System.out.println("integer");
            }else if(input.length()==1){
                System.out.println("char");
            }else if(input.length()>1){
                System.out.println("string");
            }
            input = scanner.nextLine();
        }
    }
}
