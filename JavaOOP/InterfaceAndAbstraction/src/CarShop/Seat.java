package CarShop;

public class Seat extends CarImpl implements Sellable{

    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced,Double price) {
        super(model,color,horsePower,countryProduced);
        this.price = price;
    }


    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();

        out.append(super.toString())
                .append(System.lineSeparator())
                .append(String.format("%s sells for %f",getModel(),price));
        return out.toString();
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
