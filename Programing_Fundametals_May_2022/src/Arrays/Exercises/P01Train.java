package Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] peopleOnWagon = new String[n];
        int sumOfPeople = 0;

        for (int i = 0; i <peopleOnWagon.length ; i++) {
            peopleOnWagon[i] = scanner.nextLine();
            sumOfPeople+=Integer.parseInt(peopleOnWagon[i]);
        }
        System.out.println(String.join(" ",peopleOnWagon));
        System.out.println(sumOfPeople);

    }
}
