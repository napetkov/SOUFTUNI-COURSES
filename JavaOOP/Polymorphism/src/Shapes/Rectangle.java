package Shapes;

public class Rectangle extends Shape{
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    void calculatePerimeter() {
        if(getPerimeter()==null){
            setPerimeter(2*height+2*width);
        }
    }

    @Override
    void calculateArea() {
        if(getArea()==null) {
            setArea(height * width);
        }
    }

    public final Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public final Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }
}
