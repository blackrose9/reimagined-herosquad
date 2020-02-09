import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;

public class SquadTest {
    Squad squad = new Squad("Kitchen Masters", "Good Cooking", 10);

    @Test
    public void instantiateNewSquad_true(){
        assertEquals(true, squad instanceof Squad);
    }
}