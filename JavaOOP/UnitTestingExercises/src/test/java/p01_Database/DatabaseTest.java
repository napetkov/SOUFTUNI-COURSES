package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import javax.xml.crypto.Data;

import static org.junit.Assert.*;

public class DatabaseTest {
    private static final Integer[] NUMBERS = {7, 3, 2, 1};
    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    //1. Базата се създава успешно
    @Test
    public void testConstructorCreateValidDB() throws OperationNotSupportedException {
        Integer[] dbElements = database.getElements();
        Assert.assertArrayEquals(NUMBERS, dbElements);
    }

    //2.Ексепщън при > 16 елемента
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowWithMoreThan16Elements() throws OperationNotSupportedException {
        Integer[] bigArr = new Integer[17];
        Database database = new Database(bigArr);
    }
    //3.Ексепштн при < 1 елемента
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowWithLessThan1Elements() throws OperationNotSupportedException {
        Integer[] emptyArr = new Integer[0];
        Database database = new Database(emptyArr);
    }
    //4.Добавяме null - Exzeption
    @Test(expected = OperationNotSupportedException.class)
    public void testAddNullShouldThrow() throws OperationNotSupportedException {
        database.add(null);
    }
    //5.Добавяме успешно елемент в края
    @Test
    public void testShouldAddElement() throws OperationNotSupportedException {
        database.add(42);

        Integer[] dbElements = database.getElements();

        Assert.assertEquals(dbElements[dbElements.length-1],Integer.valueOf(42));
        Assert.assertEquals(dbElements.length,NUMBERS.length+1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveThrowWithEmptyDatabase() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testRemoveShouldRemove() throws OperationNotSupportedException {
        Integer[] elementsBeforeRemove = database.getElements();
        database.remove();
        Integer[] elementAfterRemove = database.getElements();

        Assert.assertEquals(elementAfterRemove.length+1,elementsBeforeRemove.length);

        Integer curretLastElement = elementAfterRemove[elementAfterRemove.length - 1];
        Integer previousSecondToLastElement = elementsBeforeRemove[elementsBeforeRemove.length - 2];
        Assert.assertEquals(previousSecondToLastElement, curretLastElement);
    }
}