package Generics.Exercises.Threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        String name = input[0] + " "+input[1];
        String address = input[2];
        String city = input[3];

        Threeuple<String,String,String> firstThreeuple = new Threeuple<>(name,address,city);

        input = scanner.nextLine().split(" ");
        String firstName = input[0];
        Integer littersOfBeer = Integer.parseInt(input[1]);
        Boolean isDrunk = input[2].equals("drunk");

        Threeuple<String,Integer,Boolean> secondThreeuple = new Threeuple<>(firstName,littersOfBeer,isDrunk);

        input = scanner.nextLine().split(" ");
        name = input[0];
        Double accountBalance = Double.parseDouble(input[1]);
        String bankName = input[2];

        Threeuple<String,Double,String> thirdThreeuple = new Threeuple<>(name,accountBalance,bankName);


        System.out.println(firstThreeuple);
        System.out.println(secondThreeuple);
        System.out.println(thirdThreeuple);





    }
}
