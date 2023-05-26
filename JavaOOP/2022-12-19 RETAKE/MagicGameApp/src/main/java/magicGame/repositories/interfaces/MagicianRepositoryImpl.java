package magicGame.repositories.interfaces;

import magicGame.models.magicians.Magician;
import magicGame.models.magics.Magic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import static magicGame.common.ExceptionMessages.INVALID_MAGICIAN_REPOSITORY;
import static magicGame.common.ExceptionMessages.INVALID_MAGIC_REPOSITORY;

public class MagicianRepositoryImpl implements MagicianRepository<Magician> {
    private Map<String,Magician> data;

    public MagicianRepositoryImpl() {
        this.data = new LinkedHashMap<>();
    }

    @Override
    public Collection<Magician> getData() {
        return data.values();
    }

    @Override
    public void addMagician(Magician model) {
        if(model == null){
            throw new NullPointerException(INVALID_MAGICIAN_REPOSITORY);
        }
        data.put(model.getUsername(), model);
    }

    @Override
    public boolean removeMagician(Magician model) {
         data.remove(model.getUsername());
        return !data.containsKey(model.getUsername());
    }

    @Override
    public Magician findByUsername(String name) {
        return data.get(name);
    }
}
