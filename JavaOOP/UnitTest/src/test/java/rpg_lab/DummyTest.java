package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {
    private static final int HEALTH = 100;
    private static final int EXPERIENCE = 10;
    private static final int ATTACK_POINTS = 10;


    private Dummy dummy;
    private Dummy deadDummy;


    @Before
    public void setUp() {
        this.dummy = new Dummy(HEALTH,EXPERIENCE);
        this.deadDummy = new Dummy(0,EXPERIENCE);
    }

    @Test
    public void testTakeAttackShouldReduceHealth(){
        dummy.takeAttack(ATTACK_POINTS);
        assertEquals(HEALTH-ATTACK_POINTS,dummy.getHealth());
    }
    @Test(expected = IllegalStateException.class)
    public void testTakeAttackThrowsWhenDummyIsDead(){
        deadDummy.takeAttack(ATTACK_POINTS);
    }

    @Test
    public void testGivesXPWhenDummyIsDeadShouldReturnCorrectXP(){
        int actual = deadDummy.giveExperience();
        assertEquals(EXPERIENCE,actual);
    }

    @Test(expected = IllegalStateException.class)
    public void testGiveXPThrowsWhenDummyIsAlive(){
        dummy.giveExperience();
    }
}