package Animals;

public class Dog extends Animal{
    
    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    String explainSelf() {
        StringBuilder out = new StringBuilder();
        out.append(super.toString())
                .append(System.lineSeparator())
                .append("DJAAF");
        return out.toString();
    }
}
