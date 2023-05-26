package PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    //    private int numberOfToppings;
    private List<Topping> toppings;

    public Pizza(String name, int numbersOfToppings) {
        setName(name);
        setToppings(numbersOfToppings);
    }

    public double getOverallCalories() {
        double sumToppingCalories = toppings.stream().mapToDouble(Topping::calculateCalories).sum();
        return dough.calculateCalories() + sumToppingCalories;
    }

//    public void setNumberOfToppings(int numberOfToppings) {
//        if (numberOfToppings < 0 || numberOfToppings > 10) {
//            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
//        }
//        this.numberOfToppings = numberOfToppings;
//    }

    public void setToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>();

    }

    public void setName(String name) {
        if (name.trim().isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", name, getOverallCalories());
    }
}

