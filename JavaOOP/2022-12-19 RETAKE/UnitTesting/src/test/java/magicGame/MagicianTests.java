package magicGame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

public class MagicianTests {
    private Magician magician1;
    private Collection<Magic> magics;
    private Magic magic1;
    private Magic magic2;

    @Before
    public void setup() {
        magician1 = new Magician("Nikko", 100);
        magic1 = new Magic("Fire", 50);
        magic2 = new Magic("Ice", 40);
    }


    @Test(expected = NullPointerException.class)
    public void testSetUsernameShouldThrowWhenUserNameNull() {
        Magician magician = new Magician(null, 100);
    }

    @Test(expected = NullPointerException.class)
    public void testSetUsernameShouldThrowWhenUserNameIsEmprty() {
        Magician magician = new Magician("  ", 100);
    }

    @Test
    public void testGetUserNameShouldGet() {
        Magician magician = new Magician("Nik", 100);
        Assert.assertEquals("Nik", magician.getUsername());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetHealthShouldThrowWithNegativeHealth() {
        Magician magician = new Magician("Nik", -1);
    }

    @Test
    public void testGetHealthShouldGet() {
        Magician magician = new Magician("Nik", 100);
        Assert.assertEquals(100, magician.getHealth());
    }

    @Test(expected = NullPointerException.class)
    public void testAddMagicShouldThrowWhenMagicIsNull(){
        Magic magic = null;
        magician1.addMagic(magic);
    }

    @Test
    public void testAddMagicShouldAdd() {
        Assert.assertEquals(0, magician1.getMagics().size());
        magician1.addMagic(magic1);
        Assert.assertEquals(1, magician1.getMagics().size());
        magician1.addMagic(magic2);
        Assert.assertEquals(2, magician1.getMagics().size());
    }
    @Test
    public void testGetMagicsShouldReturnUnmodifiableList(){
        magician1.addMagic(magic1);
        magician1.addMagic(magic2);
        List<Magic> magics = magician1.getMagics();
        Assert.assertEquals("UnmodifiableRandomAccessList",magics.getClass().getSimpleName());
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamageShouldThrowWhenHealthIsNegativeOrZero(){
        Magician magician = new Magician("Test",0);
        magician.takeDamage(0);
    }

    @Test
    public void testTakeDamageWithDamageBiggestThanHealth(){
        Magician magician = new Magician("Test Magician",50);
        magician.takeDamage(60);
        Assert.assertEquals(0,magician.getHealth());
    }

    @Test
    public void testTakeDamageShouldReduceHealth(){
        magician1.takeDamage(40);
        Assert.assertEquals(60,magician1.getHealth());
    }

    @Test
    public void testRemoveMagicShouldRemoveMagicFromList(){
        magician1.addMagic(magic1);
        magician1.addMagic(magic2);
        Assert.assertEquals(2,magician1.getMagics().size());
        magician1.removeMagic(magic1);
        Assert.assertEquals(1,magician1.getMagics().size());
    }

    @Test
    public void testGetMagicWithGivenName(){
        magician1.addMagic(magic1);
        magician1.addMagic(magic2);

        Magic getMagic = magician1.getMagic("Ice");
        Assert.assertEquals("Ice",getMagic.getName());
    }
}
