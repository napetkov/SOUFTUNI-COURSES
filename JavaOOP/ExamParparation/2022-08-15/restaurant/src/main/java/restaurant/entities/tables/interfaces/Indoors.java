package restaurant.entities.tables.interfaces;

public class Indoors extends BaseTable{
    private static final double PRICE_PER_PERSON = 3.5;


    public Indoors(int number, int size) {
        super(number, size,PRICE_PER_PERSON);
    }

    @Override
    public double allPeople() {
        return getNumberOfPeople()*PRICE_PER_PERSON;
    }
}
