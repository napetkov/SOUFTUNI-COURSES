package easterBasket;

public class Egg {
    private String color;
    private int strength;
    private String shape;

    @Override
    public String toString() {
        return String.format("%s egg, with %d strength and %s shape.",getColor(),getStrength(),getShape());
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public Egg(String color, int strength, String shape) {
        this.color = color;
        this.strength = strength;
        this.shape = shape;
    }
}
