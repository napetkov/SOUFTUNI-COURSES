package BasicSyntaxConditionalStatementsAndLoops.Exercises;

import java.util.Scanner;

public class P01Ages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = Integer.parseInt(scanner.nextLine());

        String person = "";
        if (age >= 0 && age <= 2) {
                person = "baby";
        } else if (age > 2 && age <= 13) {
            person = "child";
        } else if (age > 13 &&age<=19){
            person = "teenager";
        } else if(age > 19 && age <= 65) {
            person = "adult";
        } else {
            person = "elder";
        }
        System.out.println(person);
    }
}
