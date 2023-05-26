package ForLoops.MoreExercises;

import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int period = Integer.parseInt(scanner.nextLine());
        int sumTreated = 0;
        int sumUntreated = 0;
        int sumTreated2 = 0;
        int doctors = 7;
        for (int i = 1; i <= period; i++) {
            int patients = Integer.parseInt(scanner.nextLine());
            if (i % 3 == 0 && sumUntreated > sumTreated) {
                doctors += 1;
            }
            if (patients > doctors) {
                sumTreated += doctors;
                sumUntreated += (patients - doctors);
            } else {
                sumTreated += patients;
            }
        }
        System.out.printf("Treated patients: %d.%n",sumTreated);
        System.out.printf("Untreated patients: %d.",sumUntreated);

    }
}
