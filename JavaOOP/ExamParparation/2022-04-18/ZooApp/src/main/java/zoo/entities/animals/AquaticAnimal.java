package zoo.entities.animals;

public class AquaticAnimal extends BaseAnimal {
    private static final double AQUATIC_ANIMAL_KG = 2.50;


    public AquaticAnimal(String name, String kind, double price) {
        super(name, kind, AQUATIC_ANIMAL_KG, price);
    }

    @Override
    public void eat() {
        double kgAfterEat = getKg() + 7.50;
        this.setKg(kgAfterEat);
    }
}
