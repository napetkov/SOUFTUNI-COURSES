package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.booths.interfaces.Booth;

import java.util.*;

public class BoothRepositoryImpl implements BoothRepository<Booth> {
    private Map<Integer,Booth> models;

    public BoothRepositoryImpl() {
        this.models = new LinkedHashMap<>();
    }

    @Override
    public Booth getByNumber(int number) {
        return models.get(number);
    }

    @Override
    public Collection<Booth> getAll() {
        return Collections.unmodifiableCollection(models.values());
    }

    @Override
    public void add(Booth booth) {
        models.put(booth.getBoothNumber(),booth);

    }
}
