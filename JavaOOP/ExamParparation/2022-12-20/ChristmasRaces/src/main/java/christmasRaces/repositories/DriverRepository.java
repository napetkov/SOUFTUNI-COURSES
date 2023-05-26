package christmasRaces.repositories;

import christmasRaces.entities.drivers.Driver;

import java.util.*;

public class DriverRepository implements Repository<Driver> {
    private Map<String,Driver> models;

    public DriverRepository() {
        models = new LinkedHashMap<>();
    }

    @Override
    public Driver getByName(String name) {
        return models.get(name);
    }

    @Override
    public Collection<Driver> getAll() {
        return Collections.unmodifiableCollection(models.values());
    }

    @Override
    public void add(Driver model) {
        models.put(model.getName(),model);

    }

    @Override
    public boolean remove(Driver model) {
        return models.remove(model.getName(),model);
    }
}
