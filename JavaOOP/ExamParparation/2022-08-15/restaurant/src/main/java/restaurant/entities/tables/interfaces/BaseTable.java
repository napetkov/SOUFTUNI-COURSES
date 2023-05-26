package restaurant.entities.tables.interfaces;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.Food;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;

import java.util.ArrayList;
import java.util.Collection;

import static restaurant.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static restaurant.common.ExceptionMessages.INVALID_TABLE_SIZE;

public abstract class BaseTable implements Table {
    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    public BaseTable(int number, int size, double pricePerPerson) {
        this.number = number;
        this.setSize(size);
        this.setNumberOfPeople(numberOfPeople);
        this.isReservedTable = false;
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
    }

    public void setSize(int size) {
        if (size < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople < 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getTableNumber() {
        return number;
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public int numberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return isReservedTable;
    }

//    @Override
//    public double allPeople() {
//        this.allPeople = numberOfPeople * pricePerPerson;
//        return allPeople;
//    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        allPeople = this.allPeople();
        this.isReservedTable = true;
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        double sumBeverage = 0;
        for (Beverages beverage : beverages) {
            sumBeverage += beverage.getPrice();
        }

        double sumHealthyFood = 0;
        for (HealthyFood food : healthyFood) {
            sumHealthyFood += food.getPrice();
        }


        return sumBeverage + sumHealthyFood + this.allPeople;
    }

    @Override
    public void clear() {
        beverages = new ArrayList<>();
        healthyFood = new ArrayList<>();
        isReservedTable = false;
        setNumberOfPeople(0);
        allPeople = 0;

    }

    @Override
    public String tableInformation() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Table - %d", number)).append(System.lineSeparator());
        sb.append(String.format("Size - %d", size)).append(System.lineSeparator());
        sb.append(String.format("Type - %s", this.getClass().getSimpleName())).append(System.lineSeparator());
        sb.append(String.format("All price - %f", this.allPeople)).append(System.lineSeparator());

        return sb.toString().trim();
    }
}
