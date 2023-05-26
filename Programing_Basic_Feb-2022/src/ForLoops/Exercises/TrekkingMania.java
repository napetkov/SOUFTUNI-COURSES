package ForLoops.Exercises;

import java.util.Scanner;

public class TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int musala = 0;
        int montBlanc = 0;
        int kilimanjaro = 0;
        int k2 = 0;
        int everest = 0;
        double totalSumTrekkers = 0;
        int numGroups = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numGroups; i++) {
            int numTrekkers = Integer.parseInt(scanner.nextLine());
            if (numTrekkers <= 5) {
                musala += numTrekkers;
            } else if (numTrekkers > 5 && numTrekkers <= 12) {
                montBlanc += numTrekkers;
            } else if (numTrekkers > 12 && numTrekkers <= 25) {
                kilimanjaro += numTrekkers;
            } else if (numTrekkers > 25 && numTrekkers <= 40) {
                k2 += numTrekkers;
            } else if (numTrekkers > 40) {
                everest += numTrekkers;
            }

        }
        totalSumTrekkers = musala+montBlanc+kilimanjaro+k2+everest;

        System.out.printf("%.2f%%%n",musala/totalSumTrekkers*100);
        System.out.printf("%.2f%%%n",montBlanc/totalSumTrekkers*100);
        System.out.printf("%.2f%%%n",kilimanjaro/totalSumTrekkers*100);
        System.out.printf("%.2f%%%n",k2/totalSumTrekkers*100);
        System.out.printf("%.2f%%%n",everest/totalSumTrekkers*100);


    }
}
