package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood {
    private boolean fightHappened;

    public boolean isFightHappened() {
        return fightHappened;
    }

    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        //       if (!mainPlayer.getGunRepository().getModels().isEmpty()) {
        for (Player civilPlayer : civilPlayers) {
            for (Gun gun : mainPlayer.getGunRepository().getModels()) {
                while (civilPlayer.isAlive() && gun.canFire()) {
                    int fireBullets = gun.fire();
                    civilPlayer.takeLifePoints(fireBullets);
                    fightHappened = true;
                }
            }
        }

        //      } else {
        for (Player civilPlayer : civilPlayers) {
            if (civilPlayer.isAlive()) {
                for (Gun gun : civilPlayer.getGunRepository().getModels()) {
                    while (mainPlayer.isAlive() && gun.canFire()) {
                        int fireBullets = gun.fire();
                        mainPlayer.takeLifePoints(fireBullets);
                        fightHappened = true;
                    }
                }
            }
        }
    }
//    }

}
