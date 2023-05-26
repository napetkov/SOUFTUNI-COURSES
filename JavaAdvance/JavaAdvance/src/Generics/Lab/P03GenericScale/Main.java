package Generics.Lab.P03GenericScale;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       Integer left = 13;
       Integer right = 42;

        Scale<Integer> stringScale = new Scale<>(left,right);

        System.out.println(stringScale.getHeavier());


    }
}
