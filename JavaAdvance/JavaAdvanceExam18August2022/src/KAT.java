import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> platesPerDay = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(platesPerDay::offer);

        ArrayDeque<Integer> carsPerDay = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(carsPerDay::push);

        int countOfRegCars = 0;
        int dayCounter = 0;

        while (!platesPerDay.isEmpty() && !carsPerDay.isEmpty()) {

            int plates = platesPerDay.poll();
            int cars = carsPerDay.pop();
            int neededPlates = cars * 2;
            int registeredCarsPerDay = 0;
            int remainingPlates = Math.abs(plates - neededPlates);

            if (plates > neededPlates) {
                registeredCarsPerDay = cars;
                platesPerDay.offer(remainingPlates);
            } else if (plates < neededPlates) {
                registeredCarsPerDay = plates / 2;
                carsPerDay.addLast(cars - registeredCarsPerDay);
            } else {
                registeredCarsPerDay = cars;
            }
            countOfRegCars += registeredCarsPerDay;
            dayCounter++;
        }
        System.out.printf("%d cars were registered for %d days!%n",countOfRegCars,dayCounter);

        if(!carsPerDay.isEmpty()){
            int sumOfRemainingNotReg = sumElements(carsPerDay);
            System.out.printf("%d cars remain without license plates!%n",sumOfRemainingNotReg);
        }else if(!platesPerDay.isEmpty()){
            System.out.printf("%d license plates remain!%n",sumElements(platesPerDay));
        }else{
            System.out.println("Good job! There is no queue in front of the KAT!");
        }




    }

    private static int sumElements(ArrayDeque<Integer> carsPerDay) {
        int sumOfRemainingNotReg = 0;
        for (int car: carsPerDay){
            sumOfRemainingNotReg +=car;
        }
    return sumOfRemainingNotReg;
    }
}
