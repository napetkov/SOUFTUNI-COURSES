package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GarageTests {
    private Garage garage;
    private Car car1;
    private Car car2;
    private Car car3;

    @Before
    public void setup() {
        garage = new Garage();
        car1 = new Car("Opel", 220, 4500.20);
        car2 = new Car("Mercedes", 300, 55000.00);
        car3 = new Car("Nissan", 330, 22000);
    }

    @Test
    public void testConstructor() {
        Assert.assertEquals(0, garage.getCount());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarNullShouldThrow() {
        Car car = null;
        garage.addCar(car);
    }

    @Test
    public void testAddCarShouldAdd() {
        Assert.assertEquals(0, garage.getCount());
        garage.addCar(car1);
        Assert.assertEquals(1, garage.getCount());
        garage.addCar(car2);
        Assert.assertEquals(2, garage.getCount());
    }

    @Test
    public void testGetCarsShouldReturnUnModifiableList() {
        garage.addCar(car1);
        garage.addCar(car2);
        Assert.assertEquals(2, garage.getCount());

        List<Car> cars = garage.getCars();

        Assert.assertEquals("UnmodifiableRandomAccessList", cars.getClass().getSimpleName());
    }

    @Test
    public void testFindAllCarsWithMaxSpeedAboveShouldFind() {
        garage.addCar(car3);
        garage.addCar(car1);
        garage.addCar(car2);

        List<Car> allCarsWithMAxSpeed = garage.findAllCarsWithMaxSpeedAbove(230);
        Assert.assertEquals(2, allCarsWithMAxSpeed.size());
        Assert.assertTrue(allCarsWithMAxSpeed.get(0).getMaxSpeed() > 230);
    }

    @Test
    public void testGetTheMostExpensiveCarShouldGet() {
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);

        Car theMostExpensiveCar = garage.getTheMostExpensiveCar();

        Assert.assertEquals("Mercedes", theMostExpensiveCar.getBrand());
        Assert.assertTrue(car1.getPrice() < theMostExpensiveCar.getPrice());
    }

    @Test
    public void testFindAllCarsByBrandShouldFind() {
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);
        Car car = new Car("Opel", 120, 2000);
        garage.addCar(car);

        List<Car> opelList = garage.findAllCarsByBrand("Opel");

        Assert.assertEquals(2,opelList.size());
        Assert.assertEquals("Opel",opelList.get(0).getBrand());
    }
}