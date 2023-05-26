package Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P07CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numberArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        if(numberArr.length==1){
            System.out.println(numberArr[0]);
        }else{

            int[] newArr = new int[numberArr.length-1];
            int counter = newArr.length;
            while(counter>0) {

                for (int i = 0; i < numberArr.length - 1; i++) {
                    newArr[i] = numberArr[i] + numberArr[i + 1];
                    numberArr[i] = newArr[i];
                }
                counter--;
            }
            System.out.println(newArr[0]);
        }
    }



    }

