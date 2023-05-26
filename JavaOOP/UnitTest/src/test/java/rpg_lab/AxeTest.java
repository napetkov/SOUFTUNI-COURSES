package rpg_lab;

import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AxeTest {
    private static final int ATTACK = 10;
    private static final int DURABILITY = 10;
    private static final int HEALTH = 10;
    private static final int EXPERIENCE = 10;


    private Axe axe;
    private Dummy dummy;
    private Axe brokenAxe;

    @Before
    public void setUp() {
        this.axe = new Axe(ATTACK, DURABILITY);
        this.dummy = new Dummy(HEALTH, EXPERIENCE);
        this.brokenAxe = new Axe(ATTACK, 0);
    }


    @Test
    public void testAttackReduceDurability() {
        axe.attack(dummy);
        int expected = DURABILITY - 1;
        assertEquals(expected, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testAttackThrowsWhenAxeIsBroken() {
        brokenAxe.attack(dummy);

    }

}
