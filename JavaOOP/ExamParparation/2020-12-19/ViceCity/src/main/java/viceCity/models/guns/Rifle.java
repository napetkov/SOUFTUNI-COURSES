package viceCity.models.guns;

public class Rifle extends BaseGun{
    private static final int BULLETS_PER_BARREL = 50;
    private static final int TOTAL_BULLETS = 450;
    private static final int RIFLE_SHOOT_WITH = 5;

    public Rifle(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        if (canFire()) {
            if (getBulletsPerBarrel() > 0) {
                setBulletsPerBarrel(getBulletsPerBarrel() - RIFLE_SHOOT_WITH);
            } else if (getBulletsPerBarrel() == 0) {
                setBulletsPerBarrel(BULLETS_PER_BARREL);
                setTotalBullets(getTotalBullets() - BULLETS_PER_BARREL);
                setBulletsPerBarrel(getBulletsPerBarrel() - RIFLE_SHOOT_WITH);
            }
        }
        return RIFLE_SHOOT_WITH;



    }
}
