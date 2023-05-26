package ObjectsAndClasses.MoreExercises.p02RawData;

public class Engine {
    String model;
    int engineSpeed;
        int enginePower;

        public Engine(String model,int engineSpeed, int enginePower) {
            this.model = model;
            this.engineSpeed = engineSpeed;
            this.enginePower = enginePower;
        }

    public int getEnginePower() {
        return enginePower;
    }

    public String getModel() {
        return model;
    }
}

