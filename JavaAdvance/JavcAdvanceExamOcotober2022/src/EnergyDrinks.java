import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> caffeine = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(caffeine::push);

        ArrayDeque<Integer> energyDrink = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(energyDrink::offer);

        int maximumCaffeine = 300;
        int stamatTotalCaffeine = 0;

        while (!caffeine.isEmpty() && !energyDrink.isEmpty()) {
            int currentCaffeine = caffeine.pop();
            int currentEnergyDrink = energyDrink.poll();
            int drunkenCaffeine = currentCaffeine * currentEnergyDrink;
            if (drunkenCaffeine <= (300-stamatTotalCaffeine)) {
                stamatTotalCaffeine += drunkenCaffeine;
                maximumCaffeine -= drunkenCaffeine;
            } else {
                energyDrink.offer(currentEnergyDrink);
               if(stamatTotalCaffeine<=0){
                   stamatTotalCaffeine=0;
               }else {
                   stamatTotalCaffeine -= 30;
               }
            }
        }

    if(!energyDrink.isEmpty()){
        System.out.print("Drinks left: ");
        System.out.println(energyDrink.stream().map(Object::toString).collect(Collectors.joining(", ")));
    }else{
        System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
    }

        System.out.printf("Stamat is going to sleep with %d mg caffeine.",stamatTotalCaffeine);


    }
}
