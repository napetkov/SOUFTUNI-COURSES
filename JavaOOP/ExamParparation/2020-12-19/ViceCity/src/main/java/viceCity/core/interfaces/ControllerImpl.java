package viceCity.core.interfaces;

import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.GunRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private MainPlayer mainPlayer;
    private Collection<Player> civilPlayers;
    private GunRepository guns;
    private GangNeighbourhood gangNeighbourhood;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.civilPlayers = new ArrayList<>();
        this.guns = new GunRepository();
        this.gangNeighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        CivilPlayer player = new CivilPlayer(name);
        civilPlayers.add(player);
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        String outputMassage = null;
        Gun gun = null;
        switch (type) {
            case "Pistol":
                gun = new Pistol(name);
                break;
            case "Rifle":
                gun = new Rifle(name);
                break;
            default:
                outputMassage = GUN_TYPE_INVALID;
        }
        if(gun != null){
            guns.add(gun);
            outputMassage = String.format(GUN_ADDED,name,type);
        }

        return outputMassage;
    }

    @Override
    public String addGunToPlayer(String name) {
        String outputMassage;
        Gun gun = null;
        if(guns.getModels().isEmpty()){
            outputMassage = GUN_QUEUE_IS_EMPTY;
            return outputMassage;
        }else{
            gun = guns.getModels().peek();
        }

        if(name.equals("Vercetti")){
            mainPlayer.getGunRepository().add(gun);
            guns.getModels().poll();
            outputMassage =String.format(GUN_ADDED_TO_MAIN_PLAYER,gun.getName(),this.mainPlayer.getName());
        }else{
            Player player = civilPlayers.stream()
                    .filter(p -> p.getName().equals(name))
                    .findFirst()
                    .orElse(null);
            if(player == null){
                outputMassage = CIVIL_PLAYER_DOES_NOT_EXIST;
            }else{
                player.getGunRepository().getModels().add(gun);
                guns.getModels().poll();
                outputMassage = String.format(GUN_ADDED_TO_CIVIL_PLAYER,gun.getName(),name);
            }
        }
        return outputMassage;
    }

    @Override
    public String fight() {
        int deadCivilPLayers = 0;
        gangNeighbourhood.action(mainPlayer,civilPlayers);

        if(!gangNeighbourhood.isFightHappened()){
            return FIGHT_HOT_HAPPENED;
        }

        for (Player civilPlayer : civilPlayers) {
            if (!civilPlayer.isAlive()){
                deadCivilPLayers++;
            }
        }

        civilPlayers.removeIf( p -> !p.isAlive());
//
//        int sizeLiveCivilPlayers = (int) civilPlayers.stream()
//                .filter(Player::isAlive)
//                .count();

        StringBuilder sb = new StringBuilder();
        sb.append(FIGHT_HAPPENED).append(System.lineSeparator());
        sb.append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE,mainPlayer.getLifePoints()))
                .append(System.lineSeparator());
        sb.append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE,deadCivilPLayers))
                .append(System.lineSeparator());
        sb.append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE,civilPlayers.size()));


        return sb.toString().trim();
    }
}
