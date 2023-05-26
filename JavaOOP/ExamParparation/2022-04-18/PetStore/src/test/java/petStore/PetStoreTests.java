package petStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PetStoreTests {
    private PetStore petStore;
    private Animal mila;
    private Animal sharo;

    @Before
    public void setup(){
        petStore = new PetStore();
        mila = new Animal("cat",20,19.99);
        sharo = new Animal("dog",30,29.99);
    }

    @Test
    public void testConstructor(){
        Assert.assertEquals(0,petStore.getCount());
    }

    @Test
    public void testAddAnimalShouldAdd(){
        Assert.assertEquals(0,petStore.getCount());
        petStore.addAnimal(mila);
        Assert.assertEquals(1,petStore.getCount());
        petStore.addAnimal(sharo);
        Assert.assertEquals(2,petStore.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalWithNullShouldThrow(){
        Animal nullAnimal = null;
        petStore.addAnimal(nullAnimal);
    }

    @Test
    public void testGetAnimalsShouldGetUnmodifiableList(){
        petStore.addAnimal(mila);
        List<Animal> animals = petStore.getAnimals();
       String aimalsClassSimplyName = animals.getClass().getSimpleName();
       Assert.assertEquals("UnmodifiableRandomAccessList",aimalsClassSimplyName);

    }

    @Test
    public void testFindAllAnimalsWithMaxKilogramsShouldFind(){
        petStore.addAnimal(mila);
        petStore.addAnimal(sharo);

        List<Animal> animalsWithMaxKg = petStore.findAllAnimalsWithMaxKilograms(29);

        Assert.assertEquals(1,animalsWithMaxKg.size());

        animalsWithMaxKg = petStore.findAllAnimalsWithMaxKilograms(19);

        Assert.assertEquals(2,animalsWithMaxKg.size());
    }

    @Test
    public void testGetMostExpensiveAnimalShouldGet(){
        petStore.addAnimal(mila);
        petStore.addAnimal(sharo);

        Animal animl = petStore.getTheMostExpensiveAnimal();

        Assert.assertEquals(animl,sharo);
    }

    @Test
    public void testFindAllAnimalBySpecie(){
        petStore.addAnimal(mila);
        petStore.addAnimal(sharo);
        Animal animal = new Animal("cat",15,5);

        List<Animal> animals = petStore.findAllAnimalBySpecie("cat");
        Assert.assertEquals(1,animals.size());

        petStore.addAnimal(animal);
        animals = petStore.findAllAnimalBySpecie("cat");
        Assert.assertEquals(2,animals.size());

        String searchingSpecie = petStore.getAnimals().get(0).getSpecie();
        Assert.assertEquals("cat", searchingSpecie);
    }





}

