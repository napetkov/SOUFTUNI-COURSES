package WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal{
    private String livingRegion;

    protected Mammal(String animalName, String animalType, double animalWeight,String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    protected void eatVegi(Food food){
        if(food.getClass().getSimpleName().equals("Vegetable")){
            setFoodEaten(getFoodEaten()+food.getQuantity());
        }else{
            throw new IllegalArgumentException(String
                    .format("%s are not eating that type of food!",this.getClass().getSimpleName()));
        }
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    public void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("##.##");

        return String.format("%s[%s, %s, %s, %d]"
                ,getAnimalType(),getAnimalName(),df.format(getAnimalWeight()),livingRegion,getFoodEaten());
    }
}
