package FirstStepsInCoding.Lab;

import java.util.Scanner;

public class ProjectsCreation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Входни данни
        String architectName = scanner.nextLine();
        int projects = Integer.parseInt(scanner.nextLine());
        //Изчисления
        int neededTime = projects * 3;
        //Печат резултат
        System.out.printf("The architect %s will need %d hours to complete %d project/s.",architectName ,neededTime ,projects);
    }
}
