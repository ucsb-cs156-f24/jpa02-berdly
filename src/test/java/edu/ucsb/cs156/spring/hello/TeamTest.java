package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(
            team
                .getName()
                .equals("test-team")
        );
    }

    @Test 
    public void getTeam_returns_correct_team_name(){
        assertEquals(
            Developer
                .getTeam()
                .getName(),
            "f24-02"
        );
    }

    @Test
    public void getTeam_returns_correct_members(){
        final String[] members = {"Jakob", "Jeffery", "Leo", "Ved", "Rushil", "Edwin"};
        final Team dev_team = Developer.getTeam();
        for(String member : members){
            assert(dev_team.getMembers().contains(member));
        }
    }

    @Test
    public void equals_self_true(){
        assertEquals(team, team);
    }

    @Test
    public void equals_equivalent_other(){
        Team other_team = new Team("test-team");
        assertEquals(team, other_team);
    }

    @Test
    public void equals_different(){
        assertNotEquals(team, Developer.getTeam());
    }

    @Test
    public void equals_different_class(){
        assertNotEquals(team, new Object());
    }
    @Test
    public void hashCode_same(){
        assertEquals(team.hashCode(), team.hashCode());
    }

    @Test
    public void hashCode_same_values(){
        assertEquals(team.hashCode(), new Team("test-team").hashCode());
    }
    @Test
    public void hashCode_equal_operations(){
        assertEquals(team.getName().hashCode() | team.getMembers().hashCode(), team.hashCode());
        Team t = new Team();
        assertEquals(t.getName().hashCode() | t.getMembers().hashCode(), t.hashCode());
    }
    @Test
    public void hashCode_different(){
        assertNotEquals(team.hashCode(), Developer.getTeam().hashCode());
    }

    @Test void toString_impl(){
        assertEquals(team.toString(), "Team(name=test-team, members=[])");
    }
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
