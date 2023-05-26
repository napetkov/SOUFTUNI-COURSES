package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    private Database database;
    private static Person[] PEOPLE;

    @Before
    public void setup() throws OperationNotSupportedException {
        PEOPLE = new Person[3];
        PEOPLE[0] = new Person(1, "Person1");
        PEOPLE[1] = new Person(2, "Person2");
        PEOPLE[2] = new Person(3, "Person3");
        database = new Database(PEOPLE);
    }

    @Test
    public void testConstructorCreateValidDB() {
        Person[] people = database.getElements();
        Assert.assertArrayEquals(people,PEOPLE);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowWhitMoreThan16Elements() throws OperationNotSupportedException {
        Person[] people = new Person[17];
        database = new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowWithNoElements() throws OperationNotSupportedException {
        Person[] people = new Person[0];
        database = new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowWithNull() throws OperationNotSupportedException {
        Person testPerson = null;
        database.add(testPerson);
    }

    @Test
    public void testShouldAddElement() throws OperationNotSupportedException {
        Person person4 = new Person(4,"Person4");

        database.add(person4);

        Assert.assertEquals(database.getElements().length,PEOPLE.length+1);
        Assert.assertEquals(person4,database.getElements()[database.getElements().length-1]);
    }

    @Test
    public void testRemoveShouldRemove() throws OperationNotSupportedException {
        Person[] peopleBeforeRemove = database.getElements();
        database.remove();
        Person[] peopleAfterRemove = database.getElements();

        Assert.assertEquals(peopleAfterRemove.length+1,peopleBeforeRemove.length);

        Person previousSecondToLastElement = peopleBeforeRemove[peopleBeforeRemove.length-2];
        Person currentLastPerson = peopleAfterRemove[peopleAfterRemove.length-1];

        Assert.assertEquals(previousSecondToLastElement,currentLastPerson);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveThrowWithEmptyDatabase() throws OperationNotSupportedException {
        for (int i = 0; i < PEOPLE.length; i++) {
            database.remove();
        }
        database.remove();
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testThrowWhenNoUserPresentByThisUsername() throws OperationNotSupportedException {
        String username = "Ivan";
        database.findByUsername(username);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testThrowWhenUsernameIsNull() throws OperationNotSupportedException {
        String username = null;
        database.findByUsername(username);
    }
    @Test
    public void testFindPersonByUsername() throws OperationNotSupportedException {
        String username = "Person1";
        Person findPerson = database.findByUsername(username);

        Assert.assertEquals(PEOPLE[0],findPerson);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testThrowWhenNoUserPresentThisId() throws OperationNotSupportedException {
        int findId = 32;
        database.findById(findId);
    }
    @Test
    public void testFindPersonById() throws OperationNotSupportedException {
        int findId = 1;
        Person findPerson = database.findById(findId);

        Assert.assertEquals(PEOPLE[0],findPerson);
    }
}