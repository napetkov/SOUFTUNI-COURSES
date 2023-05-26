package MidExamFundamentals.FundamentalsExamsMid01;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elementsList = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        int movesCounter = 0;
        boolean youWon = false;

        while (!input.equals("end")) {
            int[] indexes = Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            movesCounter++;
            int index1 = indexes[0];
            int index2 = indexes[1];
            if(isValidIndex(elementsList, index1, index2)){

                if(elementsList.get(index1).equals(elementsList.get(index2))){
                    System.out.printf("Congrats! You have found matching elements - %s!%n",elementsList.get(index1));

                    if(index1>index2){
                        elementsList.remove(index1);
                        elementsList.remove(index2);

                    }else{
                        elementsList.remove(index2);
                        elementsList.remove(index1);
                    }

                }else {
                    System.out.println("Try again!");
                }

            }else{
                System.out.println("Invalid input! Adding additional elements to the board");
                String addingElement = "-"+movesCounter+"a";
                elementsList.add(elementsList.size()/2,addingElement);
                elementsList.add(elementsList.size()/2,addingElement);
            }

            if(elementsList.isEmpty()){
                System.out.printf("You have won in %d turns!%n",movesCounter);
                youWon = true;
                break;
            }

            input = scanner.nextLine();
        }
        if(!youWon){
            System.out.println("Sorry you lose :(");
            System.out.println(elementsList.toString().replaceAll("[\\[\\],]",""));
        }

    }

    private static boolean isValidIndex(List<String> elementsList, int index1, int index2) {
        return index1 >= 0 && index2 >= 0 && index1 < elementsList.size() && index2 < elementsList.size()&&index1!=index2;
    }
}
