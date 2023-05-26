package Shapes;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(2.0,3.0);
        Shape circle = new Circle(2.0);

        rectangle.calculatePerimeter();
        rectangle.calculateArea();
        circle.calculateArea();
        circle.calculatePerimeter();

        System.out.println(rectangle.getPerimeter());
        System.out.println(rectangle.getArea());
        System.out.println("-------->");
        System.out.println(circle.getPerimeter());
        System.out.println(circle.getArea());
    }
}
