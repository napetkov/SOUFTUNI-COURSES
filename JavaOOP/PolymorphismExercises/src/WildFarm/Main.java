package WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int counterInputs = 0;

        List<Animal> animals = new ArrayList<>();
        Animal animal = null;
        Food food = null;

        while (!"End".equals(input)) {

            if (counterInputs % 2 == 0) {
                String[] animalData = input.split("\\s+");
                String animalType = animalData[0];
                String animalName = animalData[1];
                double animalWeight = Double.parseDouble(animalData[2]);
                String animalLivingRegion = animalData[3];
                String catBreed = "";

                if ("Cat".equals(animalType)) {
                    catBreed = animalData[4];
                }


                switch (animalType) {
                    case "Cat":
                        animal = new Cat(animalName, animalType, catBreed, animalWeight, animalLivingRegion);
                        break;
                    case "Tiger":
                        animal = new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
                        break;
                    case "Zebra":
                        animal = new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
                        break;
                    case "Mouse":
                        animal = new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
                        break;
                }
                animal.makeSound();

            } else {
                String[] foodData = input.split("\\s+");
                String foodType = foodData[0];
                int foodQuantity = Integer.parseInt(foodData[1]);


                try{

                    if (foodType.equals("Vegetable")) {
                        food = new Vegetable(foodQuantity);
                    } else {
                        food = new Meat(foodQuantity);
                    }
                    animal.eat(food);
                }catch (IllegalArgumentException exception){
                    System.out.println(exception.getMessage());
                }

                animals.add(animal);
            }


            input = scanner.nextLine();
            counterInputs++;
        }

        animals.forEach(a -> System.out.println(a.toString()));
    }
}
