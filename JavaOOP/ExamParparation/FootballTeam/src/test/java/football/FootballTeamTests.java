package football;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FootballTeamTests {
    private static final int VACANT_POSITIONS = 12;
    private static final String PLAYER_NAME = "Pesho";
    private static final String TEAM_NAME = "Pesho's team";

    private Footballer footballer;

    private FootballTeam footballTeam;

    @Before
    public void Setup(){
        this.footballer = new Footballer(PLAYER_NAME);

        this.footballTeam = new FootballTeam(TEAM_NAME, VACANT_POSITIONS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreatingTeamWithNoPositions(){
        new FootballTeam("test_name",-1);
    }

    @Test
    public void testCreatingTeamWithActualPositionsSetCorrectPositionsCount(){
        assertEquals(VACANT_POSITIONS,footballTeam.getVacantPositions());
    }

    @Test(expected = NullPointerException.class)
    public void testCreatingTeamWithNullNameShouldFail(){
        new FootballTeam(null,VACANT_POSITIONS);
    }

    @Test(expected = NullPointerException.class)
    public void testCreatingTeamWithEmptyNameShouldFail(){
        new FootballTeam("  ",VACANT_POSITIONS);
    }

    @Test
    public void testCreatingTeamWithNameShouldAsExpected(){
        assertEquals(TEAM_NAME,footballTeam.getName());
    }

    @Test
    public void testAddPLayerShouldIncreaseTeamMembersCount(){
        footballTeam.addFootballer(footballer);
        assertEquals(1,footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPlayerShouldFailWhenTeamIsFull(){
        FootballTeam team = new FootballTeam(TEAM_NAME, 0);
        team.addFootballer(footballer);
    }
    
    @Test
    public void testRemovePlayerShouldDecreaseTeamMemberCount(){
        footballTeam.addFootballer(footballer);
        assertEquals(1,footballTeam.getCount());

        footballTeam.removeFootballer(PLAYER_NAME);
        assertEquals(0,footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemovePlayerShouldFailWhenNoSuchPLayer(){
        footballTeam.addFootballer(footballer);
        footballTeam.removeFootballer("notAdded");
    }

    @Test
    public void testPlayerForSaleShouldDeactivatePlayer(){
        footballTeam.addFootballer(footballer);
        footballTeam.footballerForSale(footballer.getName());

        assertFalse(footballer.isActive());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemovePlayerShouldFailIfPlayerIsMissing(){
        footballTeam.addFootballer(footballer);
        footballTeam.footballerForSale("notAdded");
    }


}
