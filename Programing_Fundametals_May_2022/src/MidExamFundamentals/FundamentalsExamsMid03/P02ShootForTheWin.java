package MidExamFundamentals.FundamentalsExamsMid03;

import java.util.Arrays;
import java.util.Scanner;

public class P02ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] targets = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();
        int countOfShotTarget = 0;

        while (!input.equals("End")) {
            int index = Integer.parseInt(input);

            if(isValidIndex(targets, index)){
                int currentTarget = targets[index];
                targets[index] = -1;
                countOfShotTarget++;
                for (int i = 0; i < targets.length; i++) {

                    if(targets[i]>-1){
                        if(targets[i]>currentTarget){
                            targets[i] -= currentTarget;
                        }else{
                            targets[i] += currentTarget;
                        }
                    }

                }

            }
            input = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ",countOfShotTarget);
        System.out.println(Arrays.toString(targets).replaceAll("[\\[\\],]",""));

    }

    private static boolean isValidIndex(int[] targets, int index) {

        return index >= 0 && index < targets.length;
    }
}
