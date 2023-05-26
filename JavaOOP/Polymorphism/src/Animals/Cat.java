package Animals;

import javax.print.DocFlavor;

public class Cat extends Animal{

    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    String explainSelf() {
        StringBuilder out = new StringBuilder();
        out.append(super.toString())
                .append(System.lineSeparator())
                .append("MEEOW");
        return out.toString();
    }
}
