package List.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagonsList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int maxCapacityOfWagon = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        while(!input.equals("end")){
            List<String> inputList = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            if(inputList.get(0).equals("Add")){
                int passengers = Integer.parseInt(inputList.get(1));
                addWagonToTheEnd(wagonsList,passengers);
            }else{
                int passengersToFit = Integer.parseInt(inputList.get(0));
                fitAllPassengers(wagonsList,passengersToFit,maxCapacityOfWagon);
            }
            input = scanner.nextLine();
        }
        System.out.println(wagonsList.toString().replaceAll("[\\[\\],]",""));


    }

    private static List fitAllPassengers(List<Integer> wagonsList, int passengersToFit,int maxCapacityOfWagon) {
        for (int i = 0; i < wagonsList.size(); i++) {
            int currentPassengers = 0;
            currentPassengers = wagonsList.get(i)+passengersToFit;
            if(currentPassengers<=maxCapacityOfWagon){
                wagonsList.set(i,currentPassengers);
                break;
            }
        }
        return wagonsList;
    }

    private static List addWagonToTheEnd(List<Integer> wagonsList, int passengers) {
        wagonsList.add(passengers);

        return wagonsList;
    }
}
