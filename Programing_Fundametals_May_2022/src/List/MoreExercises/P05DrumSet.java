package List.MoreExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double saving = Double.parseDouble(scanner.nextLine());

        List<Integer> drumSet = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> newDrumList = new ArrayList<>(drumSet);
        String input = scanner.nextLine();

        while (!input.equals("Hit it again, Gabsy!")) {

            int hitPower = Integer.parseInt(input);
            for (int i = 0; i < newDrumList.size(); i++) {
                int currentDrum = newDrumList.get(i);
                int newQualityDrum = currentDrum - hitPower;
                if (newQualityDrum <= 0) {
                    double priceOfNewDrum = drumSet.get(i) * 3;
                    if (priceOfNewDrum > saving) {
                        newDrumList.remove(i);
                        drumSet.remove(i);
                        i--;
                    } else {
                        saving -= priceOfNewDrum;
                        newDrumList.set(i, drumSet.get(i));
                    }

                } else {
                    newDrumList.set(i, newQualityDrum);
                }

            }
            input = scanner.nextLine();

        }
        System.out.println(newDrumList.toString().replaceAll("[\\[\\],]",""));
        System.out.printf("Gabsy has %.2flv.",saving);
    }
}
