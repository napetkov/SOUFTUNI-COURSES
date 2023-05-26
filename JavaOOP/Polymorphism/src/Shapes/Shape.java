package Shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    abstract void calculatePerimeter();
    abstract  void calculateArea();


    public Double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

}
