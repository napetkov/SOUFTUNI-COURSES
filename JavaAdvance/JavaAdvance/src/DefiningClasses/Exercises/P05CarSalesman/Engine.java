package DefiningClasses.Exercises.P05CarSalesman;

public class Engine {

    private String model;
    private String enginePower;
    private String engineDisplacement;
    private String engineEfficiency;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(String enginePower) {
        this.enginePower = enginePower;
    }

    public String getEngineDisplacement() {
        return engineDisplacement;
    }

    public void setEngineDisplacement(String engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
    }

    public String getEngineEfficiency() {
        return engineEfficiency;
    }

    public void setEngineEfficiency(String engineEfficiency) {
        this.engineEfficiency = engineEfficiency;
    }

    public Engine(String model, String enginePower) {
        this.model = model;
        this.enginePower = enginePower;
        this.engineEfficiency = "n/a";
        this.engineDisplacement = "n/a";
    }

    public Engine(String model, String enginePower, String engineDisplacement, String engineEfficiency) {
        this(model,enginePower);
        this.engineDisplacement = engineDisplacement;
        this.engineEfficiency = engineEfficiency;
    }
}
