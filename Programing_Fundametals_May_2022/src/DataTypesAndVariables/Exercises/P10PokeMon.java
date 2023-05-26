package DataTypesAndVariables.Exercises;

import java.math.BigDecimal;
import java.util.Scanner;

public class P10PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startPokePower = Integer.parseInt(scanner.nextLine());
        int pokeTarget = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());;

        int currentPower = startPokePower;
        int counterTargets = 0;
        while (currentPower >= pokeTarget) {
            currentPower -= pokeTarget;

            BigDecimal percentOfPower = new BigDecimal(currentPower*100.00 / startPokePower) ;
            if (percentOfPower.equals(BigDecimal.valueOf(50))&&currentPower>=exhaustionFactor&&exhaustionFactor!=0) {
                currentPower = currentPower/exhaustionFactor;

            }
            counterTargets++;
        }
        System.out.println(currentPower);
        System.out.println(counterTargets);
    }
}
