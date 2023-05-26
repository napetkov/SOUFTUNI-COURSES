package FirstStepsInCoding.MoreExercises;

import java.util.Scanner;

public class TrainingLab_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double w = Double.parseDouble(scanner.nextLine());

        double h = Double.parseDouble(scanner.nextLine());
         //Превръщане в метри и вадене на коридора
             w = w * 100;
             h = h * 100;
             h = h - 100;
        //целочисленно деление
        double desks = Math.floor(h/70);
        double rows = Math.floor(w/120);
        //System.out.println(desks);
        //System.out.println(rows);

        double allDesks = desks * rows - 3;
        //System.out.println(allDesks);
        System.out.printf("%.0f",allDesks);


    }


}
