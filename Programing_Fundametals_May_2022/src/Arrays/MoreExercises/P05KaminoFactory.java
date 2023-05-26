package Arrays.MoreExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfElements = Integer.parseInt(scanner.nextLine());
        int counterOfSequence = 0;
        int bestIndex = -1;
        int[] bestDNA = new int[numberOfElements];
        int bestSumOfSequence = 0;
        int bestCountOfSequence = 0;

        String input = scanner.nextLine();

        while (!input.equals("Clone them!")) {
            int[] dna = Arrays.stream(input.split("!"))
                    .mapToInt(Integer::parseInt).toArray();
            counterOfSequence++;
            int index = -1;
            int sumOfSequence = 0;
            for (int i = 0; i < dna.length; i++) {
                if (dna[i] == 1) {
                    index = i;
                    break;
                }
            }

            for (int currentElement : dna) {
                sumOfSequence += currentElement;
            }

            if (index > bestIndex) {
                bestIndex = index;
                bestSumOfSequence = sumOfSequence;
                bestCountOfSequence = counterOfSequence;
                bestDNA = dna;
            } else if (index == bestIndex) {
                if(sumOfSequence>bestSumOfSequence){
                    bestCountOfSequence = counterOfSequence;
                    bestSumOfSequence = sumOfSequence;
                    bestDNA=dna;
                }
            }

            input = scanner.nextLine();
        }
        System.out.println();

    }
}
