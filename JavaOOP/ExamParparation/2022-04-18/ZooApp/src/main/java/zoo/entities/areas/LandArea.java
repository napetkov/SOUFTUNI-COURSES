package zoo.entities.areas;

public class LandArea extends BaseArea{
    private static final int START_LAND_AREA_CAPACITY = 25;

    public LandArea(String name) {
        super(name, START_LAND_AREA_CAPACITY);
    }
}
