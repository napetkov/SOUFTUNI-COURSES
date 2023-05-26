package restaurant.entities.tables.interfaces;

public class InGarden extends BaseTable{
    private static final double PRICE_PER_PERSON = 4.5;



    public InGarden(int number, int size) {
        super(number, size, PRICE_PER_PERSON);
    }

    @Override
    public double allPeople() {
        return getNumberOfPeople()*PRICE_PER_PERSON;
    }
}
