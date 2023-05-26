package ObjectsAndClasses.Exercises.p06vehicleCatalogue;

public class VehicleCatalogue {
    private String type;
    private String model;
    private String color;
    private int horsePower;

    public VehicleCatalogue(String type,String model,String color,int horsePower){
    this.type = type;
    this.model = model;
    this.color = color;
    this.horsePower = horsePower;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return  "Type: "+type.substring(0,1).toUpperCase()+type.substring(1)+"\n"+
                "Model: "+model+"\n"+
                "Color: "+color+"\n"+
                "Horsepower: "+horsePower;

    }
}
