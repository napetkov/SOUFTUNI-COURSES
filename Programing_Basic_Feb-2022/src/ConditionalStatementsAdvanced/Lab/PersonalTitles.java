package ConditionalStatementsAdvanced.Lab;

import java.util.Scanner;

public class PersonalTitles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double age = Double.parseDouble(scanner.nextLine());
        String sex = scanner.nextLine();

//        if (sex.equals("m")) {
//            if (age < 16) {
//                System.out.println("Master");
//            } else {
//                System.out.println("Mr.");
//            }
//
//        } else if(sex.equal("f")){
//            if (age < 16) {
//                System.out.println("Miss");
//            } else {
//                System.out.println("Ms.");
//            }
//
//        }

        switch (sex) {
            case "m":
                if (age < 16) {
                    System.out.println("Master");
                } else {
                    System.out.println("Mr.");
                }
                break;
            case "f":
                if (age < 16) {
                    System.out.println("Miss");
                } else {
                    System.out.println("Ms.");
                    break;
                }
        }
    }
}
