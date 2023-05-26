package fairyShop.repositories;

import fairyShop.models.Present;

import java.util.*;

public class PresentRepository implements Repository <Present>{
    private Map<String,Present> presents;

    public PresentRepository() {
        this.presents = new LinkedHashMap<>();
    }

    @Override
    public Collection<Present> getModels() {
        return Collections.unmodifiableCollection(presents.values());
    }

    @Override
    public void add(Present present) {
        presents.put(present.getName(), present);
    }

    @Override
    public boolean remove(Present present) {
        return presents.remove(present.getName(),present);
    }

    @Override
    public Present findByName(String name) {
        return presents.get(name);
    }
}
