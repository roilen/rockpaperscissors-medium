import org.example.move.Move;
import org.example.player.ComputerPlayer;
import org.example.player.Player;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class ComputerPlayerTest {

    private final Player computerPlayer = new ComputerPlayer();
    private final int NUM_TRIALS = 10000;

    @Test
    public void testMoveIsNotNull() {
        Optional<Move> move = computerPlayer.getMove();
        assertNotNull(move);
        assertTrue(move.isPresent());
    }

    @Test
    public void testMoveIsWithinValidRange() {
        for (int i = 0; i < NUM_TRIALS; i++) {
            Move move = computerPlayer.getMove().orElseThrow();
            assertTrue(Arrays.asList(Move.values()).contains(move));
        }
    }

    @Test
    public void testRandomnessOfMoves() {
        Set<Move> movesSeen = new HashSet<>();
        for (int i = 0; i < NUM_TRIALS; i++) {
            Move move = computerPlayer.getMove().orElseThrow();
            movesSeen.add(move);
        }
        assertEquals(Move.values().length, movesSeen.size(), "Not all moves were chosen by the computer player, which might indicate a lack of randomness.");
    }
}
