package Box;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    public double calculateSurfaceArea() {
        return 2 * length * width + calculateLateralSurfaceArea();
    }
    public double calculateLateralSurfaceArea (){
        return 2 * length * height + 2 * width * height;
    }
    public double calculateVolume(){
        return length*width*height;
    }

    public void setLength(double length) {
        validationSide(length, "Length");
        this.length = length;
    }

    public void setWidth(double width) {
        validationSide(width, "Width");
        this.width = width;
    }

    public void setHeight(double height) {
        validationSide(height, "Height");
        this.height = height;
    }

    private void validationSide(double side, String massagePrefix) {
        if (side <= 0) {
            throw new IllegalArgumentException(massagePrefix + " cannot be zero or negative.");
        }
    }
}
