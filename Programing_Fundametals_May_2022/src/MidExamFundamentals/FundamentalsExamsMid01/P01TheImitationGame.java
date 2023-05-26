package MidExamFundamentals.FundamentalsExamsMid01;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> massage = Arrays.stream(scanner.nextLine().split(""))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while(!input.equals("Decode")){
            String[] commandLine = input.split(" ");




        }

    }
}
