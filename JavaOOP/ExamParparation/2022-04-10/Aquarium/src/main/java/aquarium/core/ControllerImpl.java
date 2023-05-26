package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private DecorationRepository decorations;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;

        switch (aquariumType) {
            case "FreshwaterAquarium":
                aquarium = new FreshwaterAquarium(aquariumName);
                break;
            case "SaltwaterAquarium":
                aquarium = new SaltwaterAquarium(aquariumName);
                break;
            default:
                throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }
        aquariums.add(aquarium);

        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;

        switch (type) {
            case "Ornament":
                decoration = new Ornament();
                break;
            case "Plant":
                decoration = new Plant();
                break;
            default:
                throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }
        decorations.add(decoration);

        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decoration = decorations.findByType(decorationType);

        if (decoration == null) {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }

        Aquarium aquarium = getAquariumByName(aquariumName);

        aquarium.addDecoration(decoration);
        decorations.remove(decoration);

        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish;
        Aquarium aquarium = getAquariumByName(aquariumName);

        switch (fishType) {
            case "FreshwaterFish":
                fish = new FreshwaterFish(fishName, fishSpecies, price);
                break;
            case "SaltwaterFish":
                fish = new SaltwaterFish(fishName, fishSpecies, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }

        boolean canLive = fish.getClass().getSimpleName().equals("FreshwaterFish")&&
                aquarium.getClass().getSimpleName().equals("FreshwaterAquarium");

        if(!canLive){
            canLive = fish.getClass().getSimpleName().equals("SaltwaterFish")&&
                    aquarium.getClass().getSimpleName().equals("SaltwaterAquarium");
        }

        String result;

        if(canLive){
            aquarium.addFish(fish);
            result = String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM,fishType,aquariumName);

        }else{
            result = WATER_NOT_SUITABLE;
        }
        return result;
    }

     @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = getAquariumByName(aquariumName);
        aquarium.feed();

        return String.format(FISH_FED,aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = getAquariumByName(aquariumName);

        double fishPrice = aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();
        double decorationsPrice = aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
        double aquariumValue = fishPrice + decorationsPrice;

        return String.format(VALUE_AQUARIUM,aquariumName,aquariumValue);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();

        for (Aquarium aquarium : aquariums) {
            sb.append(aquarium.getInfo());
        }

        return sb.toString().trim();
    }

    private Aquarium getAquariumByName(String aquariumName) {
        return aquariums.stream()
                .filter(a -> a.getName().equals(aquariumName))
                .findAny()
                .orElse(null);
    }
}
