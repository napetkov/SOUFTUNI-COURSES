package DefiningClasses.Exercises.P06PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String,Trainer> trainers = new LinkedHashMap<>();

        while(!input.equals("Tournament")){
            String[] data = input.split("\\s+");
            String trainerName = data[0];
            String pokemonName = data[1];
            String element = data[2];
            int health = Integer.parseInt(data[3]);

            Pokemon pokemon = new Pokemon(pokemonName,element,health);

            if(trainers.containsKey(trainerName)){
                trainers.get(trainerName).getPokemons().add(pokemon);

            }else{
                List<Pokemon> pokemons = new ArrayList<>();
                pokemons.add(pokemon);
                Trainer trainer = new Trainer(trainerName,0,pokemons);
                trainers.put(trainerName,trainer);
            }


            input = scanner.nextLine();
        }
        String attackElement = scanner.nextLine();

        while(!attackElement.equals("End")){
            String finalAttackElement = attackElement;
            trainers.forEach((name, trainer) -> {
                if(trainer.isContainsAttackElement(finalAttackElement)){
                    trainer.setNumbersOfBadges(trainer.getNumbersOfBadges()+1);
                }else{
                    trainer.attackPokemons(trainer.getPokemons());
                    trainer.isDeadPokemon(trainer.getPokemons());
                }
            });


            attackElement = scanner.nextLine();
        }

        trainers.values()
                .stream()
                .sorted((first,second)-> Integer.compare(second.getNumbersOfBadges(), first.getNumbersOfBadges()))
                .forEach(trainer -> System.out.println(trainer.getTrainerName()+" "+trainer.getNumbersOfBadges()+
                        " "+trainer.getPokemons().size()));
    }
}
