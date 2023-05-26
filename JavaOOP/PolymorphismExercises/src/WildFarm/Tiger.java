package WildFarm;

public class Tiger extends Felime{


    public Tiger(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if(food.getClass().getSimpleName().equals("Meat")){
            setFoodEaten(getFoodEaten()+food.getQuantity());
        }else{
            throw new IllegalArgumentException(String
                    .format("%s are not eating that type of food!",this.getClass().getSimpleName()));
        }
    }
}
