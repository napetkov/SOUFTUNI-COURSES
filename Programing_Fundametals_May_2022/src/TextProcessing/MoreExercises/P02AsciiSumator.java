package TextProcessing.MoreExercises;

import java.util.Scanner;

public class P02AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstSymbol = scanner.nextLine();
        String secondSymbol = scanner.nextLine();
        String random = scanner.nextLine();

        char firstChar = firstSymbol.charAt(0);
        char secondChar =  secondSymbol.charAt(0);



        int sumBetweenChar = 0;

        for (char currentSymbol:random.toCharArray()){
            if(firstChar<secondChar){
                if(currentSymbol>firstChar&&currentSymbol<secondChar){
                    sumBetweenChar +=(int) currentSymbol;
                }

            }else{
                if(currentSymbol>secondChar&&currentSymbol<firstChar){
                    sumBetweenChar +=(int) currentSymbol;
                }
            }



        }


        System.out.println(sumBetweenChar);

    }
}
