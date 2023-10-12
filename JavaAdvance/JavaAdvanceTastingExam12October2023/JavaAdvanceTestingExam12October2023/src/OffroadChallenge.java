import java.util.*;
import java.util.stream.Collectors;

public class OffroadChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int reachedCounter = 0;

        ArrayDeque<Integer> fuel = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(fuel::push);

        ArrayDeque<Integer> consumptionIndex = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(consumptionIndex::offer);

        ArrayDeque<Integer> fuelNeeded = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(fuelNeeded::offer);


        while (!fuel.isEmpty() && !consumptionIndex.isEmpty() && !fuelNeeded.isEmpty()) {
            reachedCounter++;
            int lastFuel = fuel.peek();
            int firstConsumptionIndex = consumptionIndex.peek();
            int lastFuelNeeded = fuelNeeded.peek();
            int result = lastFuel - firstConsumptionIndex;

            if (result >= lastFuelNeeded) {
                fuel.pop();
                consumptionIndex.poll();
                fuelNeeded.poll();
                System.out.println("John has reached: Altitude " + reachedCounter);
            } else {
                System.out.println("John did not reach: Altitude " + reachedCounter);
                break;
            }
        }

        String print = "";

        if (!fuelNeeded.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("John failed to reach the top.")
                    .append(System.lineSeparator());
            if (reachedCounter > 1) {
                sb.append("Reached altitudes: ");
                for (int i = 1; i < reachedCounter; i++) {
                    if(i==reachedCounter-1){
                        sb.append(String.format("Altitude %d", i));
                    }else {
                        sb.append(String.format("Altitude %d, ", i));
                    }
                }
            } else {
                sb.append("John didn't reach any altitude.");
            }
            System.out.println(sb.toString());


        } else {
            System.out.println("John has reached all the altitudes and managed to reach the top!");
        }


    }
}
