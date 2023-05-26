package WildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime{
    private String breed;

    public Cat(String animalName, String animalType,String breed, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        setFoodEaten(getFoodEaten()+food.getQuantity());
    }
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("##.##");

        return String.format("%s[%s, %s, %s, %s, %d]"
                ,getAnimalType(),getAnimalName(),breed,df.format(getAnimalWeight()),getLivingRegion(),getFoodEaten());
    }
}
