package PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    public double calculateCalories() {
        return 2 * weight * toppingModifier(toppingType);
    }

    private double toppingModifier(String toppingType) {
        switch (toppingType) {
            case "Meat":
                return 1.20;
            case "Veggies":
                return 0.80;
            case "Cheese":
                return 1.10;
            case "Sauce":
                return 0.90;
            default:
                return 0;
        }
    }

    public void setToppingType(String toppingType) {
        switch (toppingType) {
            case "Meat":
            case "Veggies":
            case "Cheese":
            case "Sauce":
                this.toppingType = toppingType;
                break;
            default:
                throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
    }

    public void setWeight(double weight) {
        if (weight < 0 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", toppingType));
        }
        this.weight = weight;

    }
}
