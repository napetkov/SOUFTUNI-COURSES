package fairyShop.repositories;

import fairyShop.models.Helper;

import java.util.*;

public class HelperRepository implements Repository <Helper>{
    private Map<String,Helper> helpers;

    public HelperRepository() {
        this.helpers = new LinkedHashMap<>();
    }

    @Override
    public Collection<Helper> getModels() {
        return Collections.unmodifiableCollection(helpers.values());
    }

    @Override
    public void add(Helper helper) {
        helpers.put(helper.getName(), helper);
    }

    @Override
    public boolean remove(Helper helper) {
        return helpers.remove(helper.getName(),helper);
    }

    @Override
    public Helper findByName(String name) {
        if(helpers.containsKey(name)){
            return helpers.get(name);
        }
        return null;
    }
}
