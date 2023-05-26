package Shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    void calculatePerimeter() {
        if (getPerimeter() == null) {
            setPerimeter(2 * Math.PI * radius);
        }
    }

    @Override
    void calculateArea() {
        if (getArea() == null) {
            setArea(Math.PI * Math.pow(radius, 2));
        }
    }

    public final Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }
}
