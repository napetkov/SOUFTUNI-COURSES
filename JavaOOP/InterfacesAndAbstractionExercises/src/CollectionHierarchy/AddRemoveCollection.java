package CollectionHierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable{

    @Override
    public String remove() {
        return items.remove(0);
    }

    @Override
    public int add(String item) {
        items.add(item);
        return 0;
    }
}
