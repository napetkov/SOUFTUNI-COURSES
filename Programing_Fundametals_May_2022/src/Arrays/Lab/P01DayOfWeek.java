package Arrays.Lab;

import java.util.Scanner;

public class P01DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//
//        String[] days= new String[7];
//        days[0] = "Monday";
//        ...
        String[] daysOfWeek =new String[] {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
        };
        int numberOfDay = Integer.parseInt(scanner.nextLine());
       if(numberOfDay>=1&&numberOfDay<=7){
           System.out.println(daysOfWeek[numberOfDay-1]);
       }else{
           System.out.println("Invalid day!");
       }


    }
}
