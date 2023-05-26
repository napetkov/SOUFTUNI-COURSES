package ConditionalStatements.MoreExercises;

import java.util.Scanner;

public class FuelTank_Part2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fuelType = scanner.nextLine();
        double fuelVolume = Double.parseDouble(scanner.nextLine());
        String discount = scanner.nextLine();

        if (discount.equals("Yes")) {

            if (fuelVolume < 20) {
                if (fuelType.equals("Gas")) {
                    System.out.printf("%.2f lv.", (fuelVolume * (0.93 - 0.08)));
                } else if (fuelType.equals("Gasoline")) {
                    System.out.printf("%.2f lv.", (fuelVolume * (2.22 - 0.18)));
                } else if (fuelType.equals("Diesel")) {
                    System.out.printf("%.2f lv.", (fuelVolume * (2.33 - 0.12)));
                }
            } else if (fuelVolume <= 25) {
                if (fuelType.equals("Gas")) {
                    System.out.printf("%.2f lv.", (fuelVolume * (0.93 - 0.08)) * 0.92);
                } else if (fuelType.equals("Gasoline")) {
                    System.out.printf("%.2f lv.", (fuelVolume * (2.22 - 0.18)) * 0.92);
                } else if (fuelType.equals("Diesel")) {
                    System.out.printf("%.2f lv.", (fuelVolume * (2.33 - 0.12)) * 0.92);
                }
            } else if (fuelVolume > 25) {
                if (fuelType.equals("Gas")) {
                    System.out.printf("%.2f lv.", (fuelVolume * (0.93 - 0.08)) * 0.90);
                } else if (fuelType.equals("Gasoline")) {
                    System.out.printf("%.2f lv.", (fuelVolume * (2.22 - 0.18)) * 0.90);
                } else if (fuelType.equals("Diesel")) {
                    System.out.printf("%.2f lv.", (fuelVolume * (2.33 - 0.12)) * 0.90);
                }


            }

        } else if (discount.equals("No")) {
            if (fuelVolume < 20) {
                if (fuelType.equals("Gas")) {
                    System.out.printf("%.2f lv.", (fuelVolume * 0.93));
                } else if (fuelType.equals("Gasoline")) {
                    System.out.printf("%.2f lv.", (fuelVolume * 2.22));
                } else if (fuelType.equals("Diesel")) {
                    System.out.printf("%.2f lv.", (fuelVolume * 2.33));
                }
            } else if (fuelVolume <= 25) {
                if (fuelType.equals("Gas")) {
                    System.out.printf("%.2f lv.", (fuelVolume * 0.93) * 0.92);
                } else if (fuelType.equals("Gasoline")) {
                    System.out.printf("%.2f lv.", (fuelVolume * 2.22) * 0.92);
                } else if (fuelType.equals("Diesel")) {
                    System.out.printf("%.2f lv.", (fuelVolume * 2.33) * 0.92);
                }
            } else if (fuelVolume > 25) {
                if (fuelType.equals("Gas")) {
                    System.out.printf("%.2f lv.", (fuelVolume * 0.93) * 0.90);
                } else if (fuelType.equals("Gasoline")) {
                    System.out.printf("%.2f lv.", (fuelVolume * 2.22) * 0.90);
                } else if (fuelType.equals("Diesel")) {
                    System.out.printf("%.2f lv.", (fuelVolume * 2.33) * 0.90);
                }


            }


        }


    }
}

