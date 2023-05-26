package aquarium.entities.fish;

public class FreshwaterFish extends BaseFish{
    private static final int INITIAL_SIZE = 3;


    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
        this.setSize(INITIAL_SIZE);
    }

    @Override
    public void eat() {
        int sizeAfterEat = getSize() + 3;
        setSize(sizeAfterEat);
    }
}
