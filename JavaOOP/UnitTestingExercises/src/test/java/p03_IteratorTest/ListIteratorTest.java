package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {
    private ListIterator listIterator;
    private final static String[] NAMES = {"Pesho","Gosho","Tosho"};

    @Before
    public void setup() throws OperationNotSupportedException {
        listIterator = new ListIterator(NAMES);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowWithNull() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void constructorShouldCreate() throws OperationNotSupportedException {
        new ListIterator(NAMES);
        Assert.assertEquals(NAMES[0],listIterator.print());
        listIterator.move();
        Assert.assertEquals(NAMES[1],listIterator.print());
        listIterator.move();
        Assert.assertEquals(NAMES[2],listIterator.print());

    }

    @Test
    public void testHasNext(){
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void testMove(){
        Assert.assertTrue(listIterator.move());
        Assert.assertTrue(listIterator.move());
        Assert.assertFalse(listIterator.move());
    }
    @Test(expected = IllegalStateException.class)
    public void testPrintShouldThrowWithEmptyIterator() throws OperationNotSupportedException {
        ListIterator emptyIterator = new ListIterator();
        emptyIterator.print();
    }
    @Test
    public void testPrintShouldReturn(){
        Assert.assertEquals(NAMES[0],listIterator.print());
        listIterator.move();
        Assert.assertEquals(NAMES[1],listIterator.print());
        listIterator.move();
        Assert.assertEquals(NAMES[2],listIterator.print());

    }


}