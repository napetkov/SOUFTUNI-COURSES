package parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private List<Parrot> data;
    private String name;
    private int capacity;

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int count() {
        return data.size();
    }

    public void add(Parrot parrot) {
        if (this.count() < capacity) {
            data.add(parrot);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(parrot -> parrot.getName().equals(name));
    }

    public Parrot sellParrot(String name) {
        data.stream().filter(parrot -> parrot.getName().equals(name)).findFirst().get().setAvailable(false);
        return data.stream().filter(parrot -> parrot.getName().equals(name)).findFirst().get();
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> soldParrots = new ArrayList<>();
        for (Parrot parrot : data) {
            if (parrot.getSpecies().equals(species)) {
                parrot.setAvailable(false);
                soldParrots.add(parrot);
            }
        }
        return soldParrots;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Parrots available at %s:", getName())).append(System.lineSeparator());
        data.forEach(parrot -> {
            if (parrot.isAvailable()) {
                sb.append(parrot.toString()).append(System.lineSeparator());
            }
        });
        return sb.toString();
    }
}
