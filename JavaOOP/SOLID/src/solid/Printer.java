package solid;

import solid.products.Product;
import solid.products.calculator.Calculator;
import solid.products.calculator.CalorieCalculator;

import java.util.List;

public class Printer {
    private Calculator calculator;

    public Printer(Calculator calculator) {
        this.calculator = calculator;
    }

    private static final String SUM = "Sum: %f";
    private static final String AVERAGE = "Average: %f";

    public void printSum(List<Product> products) {
        System.out.printf((SUM) + "%n", calculator.total(products));
    }


    public void printAverage(List<Product> products) {
        System.out.printf((AVERAGE) + "%n", calculator.average(products));
    }
}
