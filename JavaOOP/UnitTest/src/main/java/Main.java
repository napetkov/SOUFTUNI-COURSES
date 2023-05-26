import rpg_lab.Axe;
import rpg_lab.Dummy;

public class Main {
    public static void main(String[] args) {

        Axe axe = new Axe(10,10);

        Dummy dummy = new Dummy(100,10);

        axe.attack(dummy);

        System.out.println(axe.getDurabilityPoints());
    }
}
