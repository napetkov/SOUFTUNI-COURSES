package restaurant.repositories.interfaces;

import restaurant.entities.healthyFoods.interfaces.HealthyFood;

import java.util.ArrayList;
import java.util.Collection;

public class HealthFoodRepositoryImpl implements HealthFoodRepository<HealthyFood>{
    private Collection<HealthyFood> entities;

    public HealthFoodRepositoryImpl() {
        this.entities = new ArrayList<>();
    }

    @Override
    public HealthyFood foodByName(String name) {
        return entities.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst().orElse(null);
    }

    @Override
    public Collection<HealthyFood> getAllEntities() {
        return entities;
    }

    @Override
    public void add(HealthyFood entity) {
        entities.add(entity);
    }
}
