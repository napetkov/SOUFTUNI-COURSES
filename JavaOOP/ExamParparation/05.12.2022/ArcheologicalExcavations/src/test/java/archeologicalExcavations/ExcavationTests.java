package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExcavationTests {
    private Excavation excavation;
    private Archaeologist pesho;
    private Archaeologist tosho;

    @Before
    public void setup() {
        this.excavation = new Excavation("Pernik", 10);
        this.pesho = new Archaeologist("Pesho", 100);
        this.tosho = new Archaeologist("Tosho", 50);
    }

    @Test
    public void testCreateExcavation() {
        Assert.assertEquals("Pernik", excavation.getName());
        Assert.assertEquals(10, excavation.getCapacity());
        Assert.assertEquals(0, excavation.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void constructorShouldThrowWithEmptyName() {
        Excavation excavation = new Excavation("  ", 10);
    }


    @Test(expected = NullPointerException.class)
    public void constructorShouldThrowWithNullName() {
        Excavation excavation = new Excavation(null, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldThrowWithNegativeCapacity() {
        Excavation excavation = new Excavation("Pernik", -1);
    }

    @Test
    public void testAddArcheologistShouldAdd() {
        excavation.addArchaeologist(pesho);
        Assert.assertEquals(1, excavation.getCount());
        excavation.addArchaeologist(tosho);
        Assert.assertEquals(2, excavation.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArcheologistShouldThrowWhenIsNoMoreCapacity() {
        Excavation excavation = new Excavation("Pernik", 0);
        excavation.addArchaeologist(pesho);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArcheologistShouldThrowWhenNotExist(){
        excavation.addArchaeologist(pesho);
        excavation.addArchaeologist(pesho);
    }

    @Test
    public void testRemoveArchaeologistShouldRemove(){
        excavation.addArchaeologist(pesho);
        excavation.addArchaeologist(tosho);

        Assert.assertEquals(2,excavation.getCount());
        Assert.assertTrue(excavation.removeArchaeologist(pesho.getName()));
        Assert.assertEquals(1,excavation.getCount());

    }
}
