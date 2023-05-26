package List.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numberList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> bombList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int bombNumber = bombList.get(0);
        int power = bombList.get(1);
        for (int i = 0; i < numberList.size(); i++) {
            if (numberList.get(i) == bombNumber) {
                for (int j = 0; j < power; j++) {
                    if((i+1)>numberList.size()-1){
                        break;
                    }else{
                        numberList.remove(i+1);
                    }
                }
                for (int j = 0; j < power; j++) {
                    if((i-1)<0){
                        break;
                    }else{
                        numberList.remove(i-1);
                        i--;
                    }
                }
                numberList.remove(i);
                i=0;
            }

        }
        int sumOfList = 0;
        for (int i = 0; i < numberList.size(); i++) {
            sumOfList += numberList.get(i);
        }
        System.out.println(sumOfList);

    }

}
