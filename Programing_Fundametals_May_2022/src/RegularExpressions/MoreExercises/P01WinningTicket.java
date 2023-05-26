package RegularExpressions.MoreExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P01WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> ticketsList = Arrays.stream(scanner.nextLine().split("\\s+,\\s+")).collect(Collectors.toList());
        for(String ticket:ticketsList){
            StringBuilder leftRepeat = new StringBuilder();
            int countRepeat = 0;
            for (int i = 0; i <ticket.length()/2-1 ; i++) {
                if(ticket.charAt(i)==ticket.charAt(i+1)){
                    leftRepeat.append(ticket.charAt(i));
                    if(i==ticket.length()/2-2){
                        leftRepeat.append(ticket.charAt(i));
                    }
                }else{
                    leftRepeat = new StringBuilder();
                }




//                Pattern pattern = Pattern.compile("[@#$\\^]");
//                Matcher matcher = pattern.matcher(ticket.charAt(i));

            }
            System.out.println();
        }



    }
}
