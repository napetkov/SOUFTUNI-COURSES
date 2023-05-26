package DefiningClasses.Exercises.P07Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemons = new ArrayList<>();
    private List<Parent> parents = new ArrayList<>();
    private List<Child> children = new ArrayList<>();
    private Car car;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(System.lineSeparator());
        sb.append("Company:");
        sb.append(System.lineSeparator());
        if (company != null) {
            sb.append(company.toString());
        }
        sb.append("Car:");
        sb.append(System.lineSeparator());
        if(car!=null) {
            sb.append(car.toString());
        }
        sb.append("Pokemon:");
        sb.append(System.lineSeparator());
        if(!pokemons.isEmpty()) {
            pokemons.forEach(pokemon -> sb.append(pokemon.toString()));
        }
        sb.append("Parents:");
        sb.append(System.lineSeparator());
        if(!parents.isEmpty()){
            parents.forEach(parent -> sb.append(parent.toString()));
        }
        sb.append("Children:");
        sb.append(System.lineSeparator());
        children.forEach(child -> sb.append(child.toString()));

        return sb.toString();
    }
}
