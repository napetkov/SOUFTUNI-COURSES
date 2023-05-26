package Methods.Exercises;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class P11ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] integerArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String[] input = scanner.nextLine().split(" ");
        String command = "";
        int count = 0;
        while (!input[0].equals("end")) {
            switch (input[0]) {
                case "exchange":
                    int index = Integer.parseInt(input[1]);
                    if (index <= integerArr.length - 1 && index >= 0) {
                        integerArr = exchange(index, integerArr);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "max":
                    command = input[1];
                    if (maxEvenOdd(command, integerArr) == Integer.MIN_VALUE) {
                        System.out.println("No matches");
                    } else {
                        System.out.println(maxEvenOdd(command, integerArr));
                    }
                    break;
                case "min":
                    command = input[1];
                    if (minEvenOdd(command, integerArr) == Integer.MAX_VALUE) {
                        System.out.println("No matches");
                    } else {
                        System.out.println(minEvenOdd(command, integerArr));
                    }
                    break;
                case "first":
                    command = input[2];
                    count = Integer.parseInt(input[1]);
                    if (count > integerArr.length||count<=0) {
                        System.out.println("Invalid count");
//                    } else if(count ==0){
//                        System.out.println("[]");
                    }else {
                        int[] toPrint = firstEvenOdd(count, command, integerArr);
                        System.out.print("[");
                        if (toPrint[0] != 0) {
                            System.out.print(toPrint[0]);
                        }
                        for (int i = 1; i < toPrint.length; i++) {
                            if (toPrint[i] != 0) {
                                System.out.print(", " + toPrint[i]);
                            }
                        }
                        System.out.println("]");

                    }
                    break;
                case "last":
                    command = input[2];
                    count = Integer.parseInt(input[1]);
                    if (count > integerArr.length||count<=0) {
                        System.out.println("Invalid count");
//                    } else if(count ==0){
//                        System.out.println("[]");
                    }else{
                        int[] toPrint = lastEvenOdd(count, command, integerArr);
                        System.out.print("[");
                        for (int i = toPrint.length - 1; i >= 1; i--) {
                            if (toPrint[i] != 0) {
                                System.out.print(toPrint[i] + ", ");
                            }
                        }
                        if (toPrint[0] != 0) {
                            System.out.print(toPrint[0]);
                        }
                        System.out.println("]");

                    }

                    break;
            }

            input = scanner.nextLine().split(" ");
        }
        System.out.println(Arrays.toString(integerArr));
    }

    public static int[] exchange(int index, int[] integerArr) {
        int indexNewArr = 0;
        int[] newIntArr = new int[integerArr.length];

        for (int i = index + 1; i < integerArr.length; i++) {
            newIntArr[indexNewArr] = integerArr[i];
            indexNewArr++;
        }
        index = 0;
        for (int i = indexNewArr; i < newIntArr.length; i++) {
            newIntArr[i] = integerArr[index];
            index++;
        }
        return newIntArr;
    }

    public static int maxEvenOdd(String command, int[] integerArr) {
        int indexMaxValue = Integer.MIN_VALUE;
        int maxValue = Integer.MIN_VALUE;
        switch (command) {
            case "even":
                for (int i = 0; i < integerArr.length; i++) {
                    if (integerArr[i] % 2 == 0 && integerArr[i] >= maxValue) {
                        maxValue = integerArr[i];
                        indexMaxValue = i;
                    }
                }
                break;
            case "odd":
                for (int i = 0; i < integerArr.length; i++) {
                    if (integerArr[i] % 2 != 0 && integerArr[i] >= maxValue) {
                        maxValue = integerArr[i];
                        indexMaxValue = i;
                    }
                }
                break;
        }
        return indexMaxValue;

    }

    public static int minEvenOdd(String command, int[] integerArr) {
        int indexMinValue = Integer.MAX_VALUE;
        int minValue = Integer.MAX_VALUE;
        switch (command) {
            case "even":
                for (int i = 0; i < integerArr.length; i++) {
                    if (integerArr[i] % 2 == 0 && integerArr[i] <= minValue) {
                        minValue = integerArr[i];
                        indexMinValue = i;
                    }
                }
                break;
            case "odd":
                for (int i = 0; i < integerArr.length; i++) {
                    if (integerArr[i] % 2 != 0 && integerArr[i] <= minValue) {
                        minValue = integerArr[i];
                        indexMinValue = i;
                    }
                }
                break;
        }
        return indexMinValue;
    }

    public static int[] firstEvenOdd(int count, String command, int[] integerArr) {
        int[] firstDigit = new int[count];
        int counterDigits = 0;
        switch (command) {
            case "even":
                counterDigits = 0;
                for (int i = 0; i < integerArr.length; i++) {
                    if (integerArr[i] % 2 == 0) {
                        firstDigit[counterDigits] = integerArr[i];
                        counterDigits++;
                    }
                    if (counterDigits == count) {
                        break;
                    }
                }
                break;
            case "odd":
                counterDigits = 0;
                for (int i = 0; i < integerArr.length; i++) {
                    if (integerArr[i] % 2 != 0) {
                        firstDigit[counterDigits] = integerArr[i];
                        counterDigits++;
                    }
                    if (counterDigits == count) {
                        break;
                    }
                }
                break;

        }


        return firstDigit;
    }

    public static int[] lastEvenOdd(int count, String command, int[] integerArr) {
        int[] lastDigit = new int[count];
        int counterDigits = 0;
        switch (command) {
            case "even":
                counterDigits = 0;
                for (int i = integerArr.length - 1; i >= 0; i--) {
                    if (integerArr[i] % 2 == 0) {
                        lastDigit[counterDigits] = integerArr[i];
                        counterDigits++;
                    }
                    if (counterDigits == count) {
                        break;
                    }
                }
                break;
            case "odd":
                counterDigits = 0;
                for (int i = integerArr.length - 1; i >= 0; i--) {
                    if (integerArr[i] % 2 != 0) {
                        lastDigit[counterDigits] = integerArr[i];
                        counterDigits++;
                    }
                    if (counterDigits == count) {
                        break;
                    }
                }
                break;
        }
        return lastDigit;
    }
}
