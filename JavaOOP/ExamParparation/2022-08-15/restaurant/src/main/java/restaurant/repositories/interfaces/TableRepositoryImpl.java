package restaurant.repositories.interfaces;

import restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

public class TableRepositoryImpl implements TableRepository<Table>{
    private Collection<Table> entities ;

    public TableRepositoryImpl() {
        this.entities = new ArrayList<>();
    }

    @Override
    public Collection<Table> getAllEntities() {
        return entities;
    }

    @Override
    public void add(Table entity) {
        entities.add(entity);
    }

    @Override
    public Table byNumber(int number) {
        return entities.stream()
                .filter( e -> e.getTableNumber() == number)
                .findFirst()
                .orElse(null);
    }
}
