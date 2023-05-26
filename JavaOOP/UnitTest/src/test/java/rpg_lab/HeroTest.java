package rpg_lab;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class HeroTest {


    @Test
    public void testAttackWhenTargetDiesHeroGetsExp(){

        int exp = 10;

        Target facade = mock(Target.class);
        when(facade.isDead()).thenReturn(true);
        when(facade.giveExperience()).thenReturn(exp);

        Weapon weapon = mock(Weapon.class);

        Hero hero = new Hero("Nik",weapon);

        hero.attack(facade);

        assertEquals(exp,hero.getExperience());
    }

}