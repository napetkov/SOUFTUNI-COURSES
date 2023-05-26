package PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaData = scanner.nextLine().split(" ");
        String pizzaName = pizzaData[1];
        int numberOfToppings = Integer.parseInt(pizzaData[2]);

        Pizza pizza = null;

        try {
            pizza = new Pizza(pizzaName, numberOfToppings);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        String[] doughData = scanner.nextLine().split("\\s+");
        String flourType = doughData[1];
        String bakingTechnique = doughData[2];
        double doughWeight = Double.parseDouble(doughData[3]);

        Dough dough = null;
        try {
            dough = new Dough(flourType, bakingTechnique, doughWeight);
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            return;
        }

        if(pizza != null) {
            pizza.setDough(dough);
        }else{
            return;
        }

        String commandToppings = scanner.nextLine();

        while (!commandToppings.equals("END")) {
            String toppingType = commandToppings.split("\\s+")[1];
            double toppingWeight = Double.parseDouble(commandToppings.split("\\s+")[2]);

            try {
                Topping topping = new Topping(toppingType, toppingWeight);
                pizza.addTopping(topping);
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
                return;
            }
            commandToppings = scanner.nextLine();
        }

        System.out.println(pizza.toString());

    }

}
