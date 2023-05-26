package christmasRaces.entities.cars;

import static christmasRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class SportsCar extends BaseCar{
    private static final double CUBIC_CENTIMETERS = 3000;
    private static final int MIN_HORSE_POWERS = 250;
    private static final int MAX_HORSE_POWERS = 450;



    public SportsCar(String model, int horsePower) {
        super(model, horsePower, CUBIC_CENTIMETERS);
    }

    @Override
    public void setHorsePower(int horsePower) {
        if(horsePower < MIN_HORSE_POWERS || horsePower > MAX_HORSE_POWERS){
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER,horsePower));
        }
        super.horsePower = horsePower;
    }
}
