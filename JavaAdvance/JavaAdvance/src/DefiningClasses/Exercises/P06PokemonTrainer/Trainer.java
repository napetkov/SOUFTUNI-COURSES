package DefiningClasses.Exercises.P06PokemonTrainer;

import java.util.List;

public class Trainer {
    private String trainerName;
    private int numbersOfBadges;
    private List<Pokemon> pokemons;


    public boolean isContainsAttackElement(String attackElement) {
        return this.pokemons.stream().anyMatch(pokemon -> pokemon.getElement().equals(attackElement));

    }

    public void attackPokemons(List<Pokemon> pokemons) {
        pokemons.forEach(pokemon -> pokemon.setHealth(pokemon.getHealth() - 10));
    }

    public void isDeadPokemon(List<Pokemon> pokemons) {
        pokemons.removeIf(pokemon -> pokemon.getHealth() <= 0);
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public int getNumbersOfBadges() {
        return numbersOfBadges;
    }

    public void setNumbersOfBadges(int numbersOfBadges) {
        this.numbersOfBadges = numbersOfBadges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public Trainer(String trainerName, int numbersOfBadges, List<Pokemon> pokemons) {
        this.trainerName = trainerName;
        this.numbersOfBadges = numbersOfBadges;
        this.pokemons = pokemons;
    }
}
