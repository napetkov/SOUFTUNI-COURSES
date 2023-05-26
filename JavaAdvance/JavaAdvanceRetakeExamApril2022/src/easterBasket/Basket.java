package easterBasket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Egg> data;
    private String material;
    private int capacity;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (this.capacity > this.data.size()) {
            this.data.add(egg);
        }

    }

    public boolean removeEgg(String color) {
            return data.removeIf((egg) -> egg.getColor().equals(color));

    }

    public Egg getStrongestEgg() {
        return data.stream().max((f, s) -> Integer.compare(f.getStrength(), s.getStrength())).orElse(null);
    }

    public Egg getEgg(String color) {
        return data.stream().filter(egg -> egg.getColor().equals(color)).findAny().orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s basket contains:", material)).append(System.lineSeparator());
        data.forEach(egg -> sb.append(egg.toString()).append(System.lineSeparator()));
        return sb.toString();
    }
}
