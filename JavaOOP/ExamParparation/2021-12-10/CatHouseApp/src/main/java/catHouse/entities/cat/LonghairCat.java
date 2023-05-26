package catHouse.entities.cat;

public class LonghairCat extends BaseCat {
    private static final int LONG_HAIR_CAT_KILOGRAMS = 9;

    public LonghairCat(String name, String breed, double price) {
        super(name, breed, price);
        this.setKilograms(LONG_HAIR_CAT_KILOGRAMS);
    }

    @Override
    public void eating() {
        int kilogramsAfterEating = getKilograms() + 3;
        setKilograms(kilogramsAfterEating);
    }
}
