package List.MoreExercises;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        List<String> massageList = Arrays.stream(scanner.nextLine().split(""))
                .collect(Collectors.toList());

        String result = "";

        for (int i = 0; i < numbers.length; i++) {
            int index = 0;
                int currentNumber = numbers[i];
            while(currentNumber>0){

                index+=currentNumber%10;

                currentNumber = currentNumber/10;
            }

            if(index>massageList.size()-1){

                index = index%massageList.size();
            }
            result += massageList.get(index);
            massageList.remove(index);
        }
        System.out.println(result);



    }
}
