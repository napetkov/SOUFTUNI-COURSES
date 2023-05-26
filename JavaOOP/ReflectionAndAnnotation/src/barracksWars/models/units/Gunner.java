package barracksWars.models.units;

public class Gunner extends AbstractUnit{
    public static final int GUNNERS_HEALTH = 20;
    public static final int GUNNERS_DAMAGE = 20;

    public Gunner() {
        super(GUNNERS_HEALTH, GUNNERS_DAMAGE);
    }
}
