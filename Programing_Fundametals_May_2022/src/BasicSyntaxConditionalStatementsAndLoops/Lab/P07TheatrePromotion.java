package BasicSyntaxConditionalStatementsAndLoops.Lab;

import java.util.Scanner;

public class P07TheatrePromotion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfDay = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        int priceOfTicket = 0;
       // boolean flag = true; - за да избегнем последната проверка запопрегледно
        switch (typeOfDay) {
            case "Weekday":
                if (age >= 0 && age <= 18) {
                    priceOfTicket = 12;
                }else if(age>18&&age<=64){
                    priceOfTicket = 18;
                }else if(age>64&&age<=122){
                    priceOfTicket = 12;
                }
                break;
            case "Weekend":
                if (age >= 0 && age <= 18) {
                    priceOfTicket = 15;
                }else if(age>18&&age<=64){
                    priceOfTicket = 20;
                }else if(age>64&&age<=122){
                    priceOfTicket = 15;
                }
                break;
            case "Holiday":
                if (age >= 0 && age <= 18) {
                    priceOfTicket = 5;
                }else if(age>18&&age<=64){
                    priceOfTicket = 12;
                }else if(age>64&&age<=122){
                    priceOfTicket = 10;
                }
                break;
        }
        if (age>=0&&age<=122){
            System.out.printf("%d$",priceOfTicket);
        }else{
            System.out.println("Error!");
        }
    }
}
