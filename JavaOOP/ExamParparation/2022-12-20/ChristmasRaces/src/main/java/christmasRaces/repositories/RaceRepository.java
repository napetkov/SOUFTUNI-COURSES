package christmasRaces.repositories;

import christmasRaces.entities.races.Race;

import java.util.*;

public class RaceRepository implements Repository<Race>{
   private Map<String,Race> models;

    public RaceRepository() {
        models = new LinkedHashMap<>();
    }

    @Override
    public Race getByName(String name) {
        return models.get(name);
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(models.values());
    }

    @Override
    public void add(Race model) {
        models.put(model.getName(),model);
    }

    @Override
    public boolean remove(Race model) {
        return models.remove(model.getName(),model);
    }
}
