package DefiningClasses.Exercises.P04RawData;

import java.util.List;
import java.util.Set;

public class Tire {
    private List<Double> tirePressure;
    private List<Integer> tireAge;

    public List<Double> getTirePressure() {
        return tirePressure;
    }

    public void setTirePressure(List<Double> tirePressure) {
        this.tirePressure = tirePressure;
    }

    public List<Integer> getTireAge() {
        return tireAge;
    }

    public void setTireAge(List<Integer> tireAge) {
        this.tireAge = tireAge;
    }

    public Tire(List<Double> tirePressure, List<Integer> tireAge) {
        this.tirePressure = tirePressure;
        this.tireAge = tireAge;
    }
}
