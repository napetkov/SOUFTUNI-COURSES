package viceCity.models.players;

public class CivilPlayer extends BasePlayer{
    private static final int LIFE_POINT_OF_MAIN_PLAYER = 50;

    public CivilPlayer(String name) {
        super(name, LIFE_POINT_OF_MAIN_PLAYER);
    }
}
