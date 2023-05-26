package sanctuary;

import java.util.ArrayList;
import java.util.List;

public class Habitat {
    private List<Elephant> data;
    private int capacity;


    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant){
        if(capacity> data.size()){
            data.add(elephant);
        }
    }

    public boolean remove(String name){
       return data.removeIf(elephant -> elephant.getName().equals(name));
    }

    public Elephant getElephant(String retiredFrom){
        return data.stream().filter(elephant -> elephant.getRetiredFrom().equals(retiredFrom)).findAny().orElse(null);
    }
    public Elephant getOldestElephant(){
        return data.stream().max((first,second)-> Integer.compare(first.getAge(), second.getAge())).get();
    }
    public int getAllElephants(){
        return data.size();
    }
    public String getReport(){
        StringBuilder sb = new StringBuilder();
        sb.append("Saved elephants in the park:").append(System.lineSeparator());
                data.forEach(elephant -> sb.append(String.format("%s came from: %s%n",elephant.getName(),elephant.getRetiredFrom())));
    return sb.toString();
    }

}
