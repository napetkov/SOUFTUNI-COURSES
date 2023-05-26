package MidExamFundamentals.MidExam26July;

import java.util.Scanner;

public class CountOfPossibleProblems {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfProblems = Integer.parseInt(scanner.nextLine());
        int counterOfVariations = 0;

        for (int i = 1; i <= numberOfProblems; i++) {
            for (int j = 1; j <=numberOfProblems ; j++) {
                for (int k = 1; k <=numberOfProblems ; k++) {
                    if(i!=j||i!=k||j!=k){
                        counterOfVariations++;
                    }
                }
            }
        }
        System.out.println(counterOfVariations);


    }




}
