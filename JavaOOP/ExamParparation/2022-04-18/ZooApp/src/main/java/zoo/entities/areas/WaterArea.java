package zoo.entities.areas;

public class WaterArea extends BaseArea{
    private static final int START_WATER_AREA_CAPACITY = 10;

    public WaterArea(String name) {
        super(name, START_WATER_AREA_CAPACITY);
    }
}
