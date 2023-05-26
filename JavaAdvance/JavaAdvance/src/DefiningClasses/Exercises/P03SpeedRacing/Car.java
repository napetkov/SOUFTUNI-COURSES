package DefiningClasses.Exercises.P03SpeedRacing;

public class Car {
    private String carModel;
    private double fuelAmount;
    private double fuelCostOf1km;
    private double traveledDistance;


    public Car(String carModel, double fuelAmount, double fuelCostOf1km) {
        this.carModel = carModel;
        this.fuelAmount = fuelAmount;
        this.fuelCostOf1km = fuelCostOf1km;
        this.traveledDistance = 0;
    }

    public boolean isEnoughFuel(double distanceToTravel) {
        return this.fuelAmount >= distanceToTravel * getFuelCostOf1km();
    }

    public void carTravel(double distanceToTravel) {
        double currentFuelAmount = getFuelAmount() - distanceToTravel*getFuelCostOf1km();
        setFuelAmount(currentFuelAmount);
        double currentDistance = getTraveledDistance()+distanceToTravel;
        setTraveledDistance(currentDistance);
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %.0f",carModel,fuelAmount,traveledDistance);
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setFuelCostOf1km(double fuelCostOf1km) {
        this.fuelCostOf1km = fuelCostOf1km;
    }

    public void setTraveledDistance(double traveledDistance) {
        this.traveledDistance = traveledDistance;
    }

    public String getCarModel() {
        return carModel;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelCostOf1km() {
        return fuelCostOf1km;
    }

    public double getTraveledDistance() {
        return traveledDistance;
    }

}
