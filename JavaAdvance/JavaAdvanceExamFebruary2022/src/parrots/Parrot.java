package parrots;

public class Parrot {
    private String name;
    private String species;
    private boolean available = true;

    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return String.format("Parrot (%s): %s",getSpecies(),getName());
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public Parrot(String name, String species) {
        this.name = name;
        this.species = species;
    }
}
