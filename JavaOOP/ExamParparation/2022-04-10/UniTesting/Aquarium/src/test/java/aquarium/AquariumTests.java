package aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AquariumTests {
    private Aquarium saltwaterAquarium;
    private Fish fish1;
    private Fish fish2;
    private Fish fish3;

    @Before
    public void setup() {
        this.saltwaterAquarium = new Aquarium("SaltwaterAquarium", 3);
        this.fish1 = new Fish("Salmon");
        this.fish2 = new Fish("Tuna");
        this.fish3 = new Fish("Sardine");
    }


    @Test(expected = NullPointerException.class)
    public void testConstructorWithNameNull() {
        Aquarium aquarium = new Aquarium(null, 3);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorWithEmptyName() {
        Aquarium aquarium = new Aquarium("  ", 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNegativeCapacity() {
        Aquarium aquarium = new Aquarium("SaltwaterFish", -1);
    }

    @Test
    public void testGetCapacity() {
        Assert.assertEquals(3, saltwaterAquarium.getCapacity());
    }

    @Test
    public void testGetNameShouldReturnName() {
        Assert.assertEquals("SaltwaterAquarium", saltwaterAquarium.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowWithFullCapacity() {
        Aquarium aquarium = new Aquarium("TestAquarium",0);
        aquarium.add(fish1);
    }

    @Test
    public void testAddShouldAdd(){
        Assert.assertEquals(0,saltwaterAquarium.getCount());
        saltwaterAquarium.add(fish1);
        Assert.assertEquals(1,saltwaterAquarium.getCount());
        saltwaterAquarium.add(fish2);
        Assert.assertEquals(2,saltwaterAquarium.getCount());
    }
    @Test
    public void testRemoveShouldRemove(){
        saltwaterAquarium.add(fish1);
        saltwaterAquarium.add(fish2);
        saltwaterAquarium.add(fish3);
        Assert.assertEquals(3,saltwaterAquarium.getCount());
        saltwaterAquarium.remove("Salmon");
        Assert.assertEquals(2,saltwaterAquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveShouldThrowWhenNameIsMissing(){
        saltwaterAquarium.add(fish1);
        saltwaterAquarium.add(fish2);
        saltwaterAquarium.remove("Test");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellFishShouldThrowWithTheMissingName(){
        saltwaterAquarium.add(fish1);
        saltwaterAquarium.sellFish("Test");
    }

    @Test
    public void testSellFishShouldTurnFishNotAvailable(){
        saltwaterAquarium.add(fish1);
        Assert.assertTrue(fish1.isAvailable());
        saltwaterAquarium.sellFish("Salmon");
        Assert.assertFalse(fish1.isAvailable());
    }

    @Test
    public void testReportShouldReturnCorrectOutputMassage(){
        saltwaterAquarium.add(fish1);
        saltwaterAquarium.add(fish2);
        saltwaterAquarium.add(fish3);
        String outputMassage = saltwaterAquarium.report();
        String expectedOutput = String.format("Fish available at %s: Salmon, Tuna, Sardine", saltwaterAquarium.getName());
        Assert.assertEquals(expectedOutput,outputMassage);
    }


}

