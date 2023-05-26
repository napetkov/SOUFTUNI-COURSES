package kindergarten;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Kindergarten {
    public String name;
    public int capacity;
    public List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child){
        if(capacity == this.registry.size()){
            return false;
        }else{
            this.registry.add(child);
        }
        return true;
    }

    public boolean removeChild(String firstName){
        Child childToRemove = this.registry.stream()
                .filter( child -> child.getFirstName().equals(firstName))
                .findFirst().orElse(null);

        if(childToRemove != null){
            this.registry.remove(childToRemove);
        }else{
            return false;
        }

        return true;
    }

    public int getChildrenCount(){
       return this.registry.size();
    }

    public Child getChild(String firstName){
        return this.registry
                .stream()
                .filter(child -> child.getFirstName().equals(firstName))
                .findFirst()
                .orElse(null);
    }
    public String registryReport(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Registered children in %s:%n",this.name));
        this.registry.forEach((child) ->{
            sb.append(child.toString()).append(System.lineSeparator());
        });
        return sb.toString().trim();
    }
}
