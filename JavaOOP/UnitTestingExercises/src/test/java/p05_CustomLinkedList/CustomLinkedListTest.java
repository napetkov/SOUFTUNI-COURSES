package p05_CustomLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {
    private CustomLinkedList<String> list;

    @Before
    public void setup() {
        list = new CustomLinkedList<>();
        list.add("Pesho");
        list.add("Gosho");
        list.add("Tosho");
    }

    @Test
    public void testAddShouldAdd() {
        int previousSize = list.getCount();
        list.add("Andrei");
        int currentSize = list.getCount();
        Assert.assertEquals(currentSize - 1, previousSize);
        Assert.assertEquals(list.getCount() - 1, list.indexOf("Andrei"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetShouldThrowWithNegativeIndex() {
        list.get(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetShouldThrowWithMoreThanCount() {
        list.get(list.getCount() + 1);
    }

    @Test
    public void testGetShouldGetElement() {
        Assert.assertEquals("Gosho", list.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetShouldThrowWithNegativeIndex() {
        list.get(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetShouldThrowWithMoreThanCount() {
        list.get(list.getCount() + 1);
    }

    @Test
    public void testSetShouldSetElement() {
        list.set(2, "Ivo");
        Assert.assertEquals("Ivo", list.get(2));
    }

    @Test
    public void testIndexOfShouldFindIndex(){
        assertEquals(1,list.indexOf("Gosho"));

    }

    @Test
    public void testIndexOfShouldNotFindIndex(){
        assertEquals(-1,list.indexOf("Encho"));
    }

    @Test
    public void testContainsShouldReturnTrue(){
        assertTrue(list.contains("Pesho"));
    }

    @Test
    public void testContainsShouldReturnFalse(){
        assertFalse(list.contains("Ivo"));
    }

    @Test
    public void testRemoveMissingElement(){
        assertEquals(-1,list.remove("Ivan"));
    }

    @Test
    public void testRemoveShouldRemoveElement(){
        int countBefore = list.getCount();
        assertEquals(1,list.remove("Gosho"));
        assertEquals(countBefore-1,list.getCount());
        assertEquals(-1,list.indexOf("Gosho"));
    }

    @Test
    public void testRemoveAtShouldRemove(){
        int countBefore = list.getCount();
        assertEquals("Gosho",list.removeAt(1));
        assertEquals(countBefore-1,list.getCount());
        assertEquals(-1,list.indexOf("Gosho"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtShouldThrowWithNegativeIndex() {
        list.get(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtShouldThrowWithMoreThanCount() {
        list.get(list.getCount() + 1);
    }
}