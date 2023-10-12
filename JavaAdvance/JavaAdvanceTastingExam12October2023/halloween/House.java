package halloween;

import java.util.ArrayList;
import java.util.List;

public class House {
    private int capacity;
    private List<Kid> data;

    public House(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addKid(Kid kid) {
        if (capacity > data.size()) {
            data.add(kid);
        }
    }

    public boolean removeKid(String name) {
//        boolean isExist = false;
//        for (Kid kid : data) {
//            if (kid.getName().equals(name)) {
//                isExist = true;
//                data.remove(kid);
//                break;
//            }
//        }

        Kid findedKid = data.stream().filter(k -> k.getName().equals(name)).findAny().orElse(null);
        if (findedKid == null) {
            return false;
        } else {
            data.remove(findedKid);
            return true;
        }
    }

    public Kid getKid(String street) {
        return data.stream().filter(k -> k.getStreet().equals(street)).findAny().orElse(null);
    }

    public int getAllKids() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Children who visited a house for candy:")
                .append(System.lineSeparator());
        data.forEach(k ->
                sb.append(
                        String.format("%s from %s street"
                                ,k.getName(),
                                k.getStreet())
                )
                        .append(System.lineSeparator()));

        return sb.toString();
    }

    public int getCapacity() {
        return capacity;
    }

    public House setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public List<Kid> getData() {
        return data;
    }

    public House setData(List<Kid> data) {
        this.data = data;
        return this;
    }
}
