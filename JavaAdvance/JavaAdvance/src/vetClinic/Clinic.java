package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<Pet> pets;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.pets = new ArrayList<>();
    }
    public void add(Pet pet){
        pets.add(pet);
    }
    public boolean remove(String petName){
        Pet currentPet = pets.stream().filter(pet -> pet.getName().equals(petName)).findFirst().orElse(null);
        if(pets.contains(currentPet)){
            pets.remove(currentPet);
            return true;
        }
        return false;
    }
    public Pet getOldestPet(){
        return pets.stream().max((first,second)-> Integer.compare(first.getAge(), second.getAge())).get();
    }

    public Pet getPet(String namePet,String owner){
        return  pets.stream()
                .filter(pet -> (pet.getName().equals(namePet))&&(pet.getOwner().equals(owner)))
                .findFirst().orElse(null);
    }
    public int getCount(){
        return pets.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The clinic has the following patients:");
        sb.append(System.lineSeparator());
        pets.forEach(pet -> {
            sb.append(String.format("%s %s%n",pet.getName(),pet.getOwner()));
        });
        return sb.toString();
    }
}
