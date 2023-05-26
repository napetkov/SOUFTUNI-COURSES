package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private ToyRepository toys;
    private Map<String, House> houses;

    public ControllerImpl() {
        toys = new ToyRepository();
        houses = new LinkedHashMap<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house;

        switch (type) {
            case "ShortHouse":
                house = new ShortHouse(name);
                break;
            case "LongHouse":
                house = new LongHouse(name);
                break;
            default:
                throw new NullPointerException(INVALID_HOUSE_TYPE);
        }
        houses.put(house.getName(), house);
        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy;

        switch (type) {
            case "Ball":
                toy = new Ball();
                break;
            case "Mouse":
                toy = new Mouse();
                break;
            default:
                throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }
        toys.buyToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = toys.findFirst(toyType);

        if (toy == null) {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }

        House house = houses.get(houseName);
        house.buyToy(toy);
        toys.removeToy(toy);

        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;
        House house = houses.get(houseName);
        String result;
        boolean canLive = false;

        switch (catType) {
            case "ShorthairCat":
                cat = new ShorthairCat(catName,catBreed,price);
                canLive = house.getClass().getSimpleName().equals("ShortHouse");
                break;
            case "LonghairCat":
                cat = new LonghairCat(catName,catBreed,price);
                canLive = house.getClass().getSimpleName().equals("LongHouse");
                break;
            default:
                throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }

        if(canLive){
          result = String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE,catType,houseName);
          house.addCat(cat);
        }else{
            result = UNSUITABLE_HOUSE;
        }

        return result;
    }

    @Override
    public String feedingCat(String houseName) {
        House house = houses.get(houseName);
        house.feeding();
        int feedingCats = house.getCats().size();

        return String.format(FEEDING_CAT,feedingCats);
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = houses.get(houseName);

        double sumOfAllToysPrices = house.getToys()
                .stream()
                .mapToDouble(Toy::getPrice)
                .sum();
        double sumOfAllCatsPrices = house.getCats()
                .stream()
                .mapToDouble(Cat::getPrice)
                .sum();


        return String.format(VALUE_HOUSE,houseName,sumOfAllToysPrices+sumOfAllCatsPrices);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (House house : houses.values()) {
            sb.append(house.getStatistics());
        }
        return sb.toString().trim();
    }
}
