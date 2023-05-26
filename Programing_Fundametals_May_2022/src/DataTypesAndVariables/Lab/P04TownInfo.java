package DataTypesAndVariables.Lab;

import java.util.Scanner;

public class P04TownInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String townName = scanner.nextLine();
        String townPopulation = scanner.nextLine();
        String townArea = scanner.nextLine();

        System.out.printf("Town %s has population of %s and area %s square km.",townName,townPopulation,townArea);



    }
}
