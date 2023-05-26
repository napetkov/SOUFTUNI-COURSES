package List.MoreExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int middleIndex = numbers.size()/2;

        double resultFirstCar = 0;
        double resultSecondCar = 0;

        List<Integer> firstCar = numbers.subList(0,middleIndex);
        List<Integer> secondCar = numbers.subList(middleIndex+1, numbers.size());

        for (int i = 0; i < firstCar.size(); i++) {
            if(firstCar.get(i)==0){
                resultFirstCar = resultFirstCar*0.8;
            }
            resultFirstCar+=firstCar.get(i);
        }
        for (int i = secondCar.size()-1; i >= 0; i--) {
            if(secondCar.get(i)==0){
                resultSecondCar = resultSecondCar*0.8;
            }
            resultSecondCar+=secondCar.get(i);
        }

        if(resultFirstCar<resultSecondCar){
            System.out.printf("The winner is left with total time: %.1f",resultFirstCar);
        }else if(resultSecondCar<resultFirstCar){
            System.out.printf("The winner is right with total time: %.1f",resultSecondCar);
        }
    }
}
