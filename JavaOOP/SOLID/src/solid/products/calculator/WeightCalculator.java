package solid.products.calculator;

import solid.products.Product;

import java.util.List;

public class WeightCalculator {

    public double total(List<Product> products){
      return   products.stream().mapToDouble(Product::getKilograms).sum();
    }
    public double average(List<Product> products){
        return total(products)/ products.size();
    }

}
