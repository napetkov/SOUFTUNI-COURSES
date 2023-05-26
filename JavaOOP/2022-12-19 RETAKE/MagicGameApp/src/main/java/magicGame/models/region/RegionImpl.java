package magicGame.models.region;

import magicGame.models.magicians.Magician;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class RegionImpl implements Region {
    private Collection<Magician> wizardMagicians;
    private Collection<Magician> blackWidowsMagicians;

    public RegionImpl() {
        this.wizardMagicians = new ArrayList<>();
        this.blackWidowsMagicians = new ArrayList<>();
    }

    @Override
    public String start(Collection<Magician> magicians) {
        wizardMagicians = magicians.stream()
                .filter(m -> m.getClass().getSimpleName().equals("Wizard"))
                .collect(Collectors.toList());
        blackWidowsMagicians = magicians.stream()
                .filter(m -> m.getClass().getSimpleName().equals("BlackWidow"))
                .collect(Collectors.toList());

        while (!blackWidowsMagicians.isEmpty() && !wizardMagicians.isEmpty()) {
            for (Magician wizardMagician : wizardMagicians) {
                for (Magician blackWidowsMagician : blackWidowsMagicians) {
                    if (wizardMagician.getMagic().getBulletsCount() > 0) {
                        int damageAfterFire = wizardMagician.getMagic().fire();
                        if (damageAfterFire > 0) {
                            blackWidowsMagician.takeDamage(damageAfterFire);
                        }
                    }
                    if (blackWidowsMagician.getMagic().getBulletsCount() > 0) {
                        int damageAfterFire = blackWidowsMagician.getMagic().fire();
                        if (damageAfterFire > 0) {
                            wizardMagician.takeDamage(damageAfterFire);
                        }
                    }
                }
            }
            wizardMagicians.removeIf(m -> m.getHealth() == 0);
            blackWidowsMagicians.removeIf(m -> m.getHealth() == 0);
        }


//        for (Magician blackWidowsMagician : blackWidowsMagicians) {
//            for (Magician wizardMagician : wizardMagicians) {
//                if (blackWidowsMagician.isAlive()) {
//                    while (wizardMagician.isAlive()) {
//                        int damageAfterFire = blackWidowsMagician.getMagic().fire();
//                        if (damageAfterFire > 0) {
//                            wizardMagician.takeDamage(damageAfterFire);
//                        }
//                    }
//                }
//            }
//        }



        String outputMassage = null;

        if (wizardMagicians.isEmpty()) {
            outputMassage = "Black widows win!";
        } else {
            outputMassage = "Wizards win!";
        }

        return outputMassage;
    }
}
