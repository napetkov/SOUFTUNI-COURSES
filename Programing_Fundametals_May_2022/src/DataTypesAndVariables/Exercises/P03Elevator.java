package DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class P03Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double persons = Double.parseDouble(scanner.nextLine());;
        double capacity = Double.parseDouble(scanner.nextLine());;
        System.out.printf("%.0f",Math.ceil(persons/capacity));


    }
}
