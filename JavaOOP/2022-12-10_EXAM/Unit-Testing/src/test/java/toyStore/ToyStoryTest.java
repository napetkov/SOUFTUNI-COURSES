package toyStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Map;

public class ToyStoryTest {
    private ToyStore toyStore;
    private Toy toy1;
    private Toy toy2;
    private Toy toy3;

    @Before
    public void setup() {
        this.toyStore = new ToyStore();
        this.toy1 = new Toy("Truck", "001");
        this.toy2 = new Toy("Doll", "002");
        this.toy3 = new Toy("Puppy","003");
    }

    @Test
    public void testGetToyShelfShouldReturnUnmodifiableMap() {
        Map<String, Toy> toyShelf = toyStore.getToyShelf();
        Assert.assertEquals("UnmodifiableMap", toyShelf.getClass().getSimpleName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToyToMissingShelfShouldThrow() throws OperationNotSupportedException {
        toyStore.addToy("Q", toy1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToyToShelfWithAddedToysShelfShouldThrow() throws OperationNotSupportedException {
        toyStore.addToy("A", toy1);
        toyStore.addToy("A", toy2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddToyShouldThrowIfItemAlreadyExist() throws OperationNotSupportedException {
        toyStore.addToy("A",toy1);
        toyStore.addToy("C",toy1);
    }

    @Test
    public void testAddToyShouldAdd() throws OperationNotSupportedException {
        toyStore.addToy("A",toy1);
        toyStore.addToy("B",toy2);

        Map<String, Toy> toyShelf = toyStore.getToyShelf();
        Toy actual = toyShelf.get("A");

        Assert.assertEquals(toy1, actual);
    }
    @Test
    public void testAddToyWithTheCorrectOutPutMassage() throws OperationNotSupportedException {
        String outputMassage = toyStore.addToy("A", toy1);
        Assert.assertEquals(String.format("Toy:%s placed successfully!",toy1.getToyId()),outputMassage);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToyShouldThrowIfTheShelfIsMissing() {
        toyStore.removeToy("Q", toy1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToyShouldThrowIfTheSToyIsMissing() throws OperationNotSupportedException {
        toyStore.addToy("A",toy1);
        toyStore.addToy("A",toy2);
        toyStore.removeToy("A", toy3);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowWenTheItemExist() throws OperationNotSupportedException {
        toyStore.addToy("A", toy1);
        toyStore.addToy("B", toy1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToyShouldRemove() throws OperationNotSupportedException {
        toyStore.addToy("A",toy1);
        toyStore.addToy("B",toy2);
        toyStore.addToy("C",toy3);
        Map<String, Toy> toyShelf = toyStore.getToyShelf();

        toyStore.removeToy("A",toy1);
        toyStore.removeToy("A",toy1);
    }

    @Test
    public void testRemoveToyCorrectOutputMassage() throws OperationNotSupportedException {
        toyStore.addToy("A",toy1);
        String outputMassage = toyStore.removeToy("A", toy1);

        Assert.assertEquals(String.format("Remove toy:%s successfully!",toy1.getToyId()),outputMassage);

    }

    @Test
    public void testGetManufacturerShouldGet(){
        Assert.assertEquals("Puppy",toy3.getManufacturer());
    }
}