import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SquadTest {
    @After
    public void tearDown() throws Exception { Squad.clearAllSquads(); }

    Squad squad = new Squad("Kitchen Masters", "Good Cooking", 10, "info");
    Squad squad2 = new Squad("Spice Masters", "Good Cooking", 10, "warning");
    Squad squad3 = new Squad("Sous Masters", "Good Cooking", 10, "success");
    Squad squad4 = new Squad("Meat Masters", "Good Cooking", 10, "danger");

    @Test
    public void instantiateNewSquad_true(){
        assertEquals(true, squad instanceof Squad);
    }

    @Test
    public void AllSquadsAreCorrectlyReturned_true() {
        assertEquals(4, Squad.getAll().size());
    }

    @Test
    public void all_returnsAllSquadsContainsAllSquadsDeets_true() {
        assertTrue(Squad.getAll().contains(squad2));
        assertTrue(Squad.getAll().contains(squad4));
    }

    @Test
    public void getId_squadsInstantiateWithAnID_1() throws Exception{
        tearDown();
        Squad aSquad = squad;
        assertEquals(1, aSquad.getId());
    }

    @Test
    public void findReturnsCorrectPostWhenMoreThanOnePostExists() throws Exception {
        assertEquals(3, Squad.findById(squad3.getId()).getId());
    }
}