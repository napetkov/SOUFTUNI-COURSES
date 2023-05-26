package shelter;

import java.util.ArrayList;
import java.util.List;

public class Shelter {
    private List<Animal> data;
    private int capacity;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal){
        if(this.capacity>this.getCount()){
            data.add(animal);
        }
    }
    public int getCount(){
        return data.size();
    }
    public boolean remove(String name){
        return data.removeIf(animal -> animal.getName().equals(name));
    }
    public Animal getAnimal(String name, String caretaker){
        return data.stream().filter(animal1 -> animal1.getName().equals(name)
        &&animal1.getCaretaker().equals(caretaker)).findFirst().orElse(null);
    }
    public Animal getOldestAnimal(){
        return data.stream().max((f,s)->Integer.compare(f.getAge(),s.getAge())).get();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The shelter has the following animals:")
                .append(System.lineSeparator());
        for (Animal animal : data) {
            sb.append(String.format("%s %s",animal.getName(),animal.getCaretaker()))
                    .append(System.lineSeparator());
        }
        return  sb.toString();
    }
}
