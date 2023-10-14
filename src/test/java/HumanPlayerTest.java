import org.example.InputHandler;
import org.example.move.Move;
import org.example.player.HumanPlayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class HumanPlayerTest {

    private InputHandler inputHandler;
    private HumanPlayer humanPlayer;

    @BeforeEach
    public void setUp() {
        inputHandler = Mockito.mock(InputHandler.class);
        humanPlayer = new HumanPlayer(inputHandler);
    }

    @Test
    public void testDelegatesToInputHandler() {
        when(inputHandler.getUserMove()).thenReturn(Optional.of(Move.ROCK));

        Optional<Move> move = humanPlayer.getMove();

        verify(inputHandler, times(1)).getUserMove();
        assertEquals(Optional.of(Move.ROCK), move);
    }

    @Test
    public void testHandlesNoMove() {
        when(inputHandler.getUserMove()).thenReturn(Optional.empty());

        Optional<Move> move = humanPlayer.getMove();

        verify(inputHandler, times(1)).getUserMove();
        assertEquals(Optional.empty(), move);
    }
}
