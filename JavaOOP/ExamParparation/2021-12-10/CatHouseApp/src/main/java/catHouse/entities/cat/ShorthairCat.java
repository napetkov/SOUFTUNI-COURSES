package catHouse.entities.cat;

public class ShorthairCat extends BaseCat{
    private static final int SHORT_HAIR_CAT_KILOGRAMS = 7;


    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
        this.setKilograms(SHORT_HAIR_CAT_KILOGRAMS);
    }


    @Override
    public void eating() {
        int kilogramsAfterEating = getKilograms() + 1;
        setKilograms(kilogramsAfterEating);
    }
}
