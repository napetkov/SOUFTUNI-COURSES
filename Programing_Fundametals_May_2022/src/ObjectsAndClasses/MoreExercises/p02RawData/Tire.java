package ObjectsAndClasses.MoreExercises.p02RawData;

public class Tire {

    String model;
    int tire1Age;
    double tire1Pressure;
    int tire2Age;
    double tire2Pressure;
    int tire3Age;
    double tire3Pressure;
    int tire4Age;
    double tire4Pressure;

    public Tire(String model,double tire1Pressure, int tire1Age, double tire2Pressure, int tire2Age,
                double tire3Pressure, int tire3Age, double tire4Pressure, int tire4Age) {
        this.model = model;
        this.tire1Age = tire1Age;
        this.tire1Pressure = tire1Pressure;
        this.tire2Age = tire2Age;
        this.tire2Pressure = tire2Pressure;
        this.tire3Age = tire3Age;
        this.tire3Pressure = tire3Pressure;
        this.tire4Age = tire4Age;
        this.tire4Pressure = tire4Pressure;
    }

    public double getTire1Pressure() {
        return tire1Pressure;
    }

    public double getTire2Pressure() {
        return tire2Pressure;
    }

    public double getTire3Pressure() {
        return tire3Pressure;
    }

    public double getTire4Pressure() {
        return tire4Pressure;
    }

    public String getModel() {
        return model;
    }
}

