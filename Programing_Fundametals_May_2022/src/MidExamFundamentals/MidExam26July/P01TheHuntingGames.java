package MidExamFundamentals.MidExam26July;

import java.util.Scanner;

public class P01TheHuntingGames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int players = Integer.parseInt(scanner.nextLine());
        double groupEnergy = Double.parseDouble(scanner.nextLine());
        double waterPerDayPerPerson = Double.parseDouble(scanner.nextLine());
        double foodPerDayPerPerson = Double.parseDouble(scanner.nextLine());

        double groupWater = days*players*waterPerDayPerPerson;
        double groupFood = days*players*foodPerDayPerPerson;
        boolean isEnoughEnergy = true;

        for (int i = 1; i <= days; i++) {
            double lossEnergyPerDay = Double.parseDouble(scanner.nextLine());
            groupEnergy-=lossEnergyPerDay;
            if(groupEnergy<=0){
                System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.",groupFood,groupWater);
                isEnoughEnergy = false;
                break;
            }

            if(i%2==0){
                groupEnergy = groupEnergy*1.05;
                groupWater = groupWater*0.7;
            }
            if(i%3==0){
                double foodPerThirdDay = groupFood/players;
                groupFood -= foodPerThirdDay;
                groupEnergy = groupEnergy*1.1;
            }

        }
        if(isEnoughEnergy){
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy!",groupEnergy);
        }


    }
}
