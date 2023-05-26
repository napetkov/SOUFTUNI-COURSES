package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class HouseTests {
    private Cat cat1;
    private Cat cat2;
    private House house;
    @Before
    public void setup(){
        this.house = new House("BigMamasHouse",2);
        cat1 = new Cat("Nana");
        cat2 = new Cat("Mimi");
    }

    @Test
    public void testConstructorCatWithCorrectNameCat(){
        Assert.assertEquals("Nana",cat1.getName());
        Assert.assertEquals("Mimi",cat2.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorHouseWithNullName(){
        House nullNameHouse = new House(null,10);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorHouseWithEmptyName(){
        House emptyNameHouse = new House(" ",5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHouseConstructorWithNegativeCapacity(){
        House houseWithNegativeCapacity = new House("test", -1);
    }

    @Test
    public void testGetName(){
        Assert.assertEquals("BigMamasHouse",house.getName());
    }

    @Test
    public void testGetCapacity(){
        Assert.assertEquals(2,house.getCapacity());
    }

    @Test
    public void testAddCatShouldAdd(){
        Assert.assertEquals(0,house.getCount());
        house.addCat(cat1);
        Assert.assertEquals(1,house.getCount());
        house.addCat(cat2);
        Assert.assertEquals(2,house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatShouldThrowThenIsNotEnoughCapacity(){
        Cat cat = new Cat("Tom");
        house.addCat(cat1);
        house.addCat(cat2);
        house.addCat(cat);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatShouldThrowWhenMissingCat(){
        house.addCat(cat1);
        house.addCat(cat2);
        house.removeCat("Tom");
    }

    @Test
    public void testRemoveCatShouldRemoveByName(){
        house.addCat(cat1);
        house.addCat(cat2);
        Assert.assertEquals(2,house.getCount());
        house.removeCat("Nana");
        Assert.assertEquals(1,house.getCount());
        String statistic = String.format("The cat Mimi is in the house %s!",house.getName());
        Assert.assertEquals(statistic,house.statistics());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleShouldThrowWhenMissingCat(){
        house.addCat(cat1);
        house.addCat(cat2);
        house.catForSale("Tom");
    }

    @Test
    public void testCatForSaleShouldTurnTrueIsHungry(){
        house.addCat(cat1);
        house.addCat(cat2);
        Assert.assertTrue(cat1.isHungry());

        house.catForSale("Nana");
        Assert.assertFalse(cat1.isHungry());

    }

    @Test
    public void testGetStatisticShouldGivCorrectStringStatistic(){
        house.addCat(cat1);
        house.addCat(cat2);
        String statistic = String.format("The cat Nana, Mimi is in the house %s!",house.getName());
        Assert.assertEquals(statistic,house.statistics());
    }


}
