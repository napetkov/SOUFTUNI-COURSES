package DataTypesAndVariables.Lab;

import java.util.Scanner;

public class P08LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char symbol = scanner.nextLine().charAt(0);
            //if (symbol>='A'&&symbol<='Z')
        if(Character.isUpperCase(symbol)){
        //if (symbol >= 65 && symbol <= 90) {
            System.out.println("upper-case");
            //if (symbol>='a'&&symbol<='z')
        } else if (Character.isLowerCase(symbol)){
        //(symbol >= 97 && symbol <= 122) {
            System.out.println("lower-case");
        }


    }
}
