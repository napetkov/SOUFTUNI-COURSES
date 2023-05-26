package List.Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P07AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<String> inputLine = Arrays.stream(input.split("\\|"))
                .collect(Collectors.toList());

            Collections.reverse(inputLine);
        System.out.println(inputLine.toString().replace("[","").replace("]","")
                .trim().replaceAll(",","").replaceAll("\\s+"," "));

//        for (int i = 0; i < inputLine.size(); i++) {
//            if(inputLine.get(i).isEmpty()){
//                continue;
//            }
//            List<Integer> numberList = Arrays.stream(inputLine.get(i).split("")).map(Integer::parseInt)
//                    .collect(Collectors.toList());
//            System.out.print(numberList.toString().replaceAll("[\\[\\],]",""));
//            System.out.print(" ");
      //  }

    }
}
