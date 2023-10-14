import org.example.RockPaperScissorsGame;
import org.example.move.Move;
import org.example.player.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RockPaperScissorsGameTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testStreamCapture() {
        System.out.println("Test capture");
        assertTrue(outContent.toString().contains("Test capture"));
    }

    @Test
    public void testPlayer1Wins() {
        Player player1 = mock(Player.class);
        Player player2 = mock(Player.class);
        // Given
        when(player1.getMove()).thenReturn(Optional.of(Move.ROCK)).thenReturn(Optional.empty());
        when(player2.getMove()).thenReturn(Optional.of(Move.SCISSORS)).thenReturn(Optional.empty());

        RockPaperScissorsGame game = new RockPaperScissorsGame(player1, player2);
        // When
        game.start();

        // Then
        assertTrue(outContent.toString().contains("Player1 wins!"));
    }

    @Test
    public void testPlayer2Wins() {
        Player player1 = mock(Player.class);
        Player player2 = mock(Player.class);
        // Given
        when(player1.getMove()).thenReturn(Optional.of(Move.ROCK)).thenReturn(Optional.empty());
        when(player2.getMove()).thenReturn(Optional.of(Move.PAPER)).thenReturn(Optional.empty());

        RockPaperScissorsGame game = new RockPaperScissorsGame(player1, player2);
        // When
        game.start();

        // Then
        assertTrue(outContent.toString().contains("Player2 wins!"));
    }

    @Test
    public void testDraw() {
        Player player1 = mock(Player.class);
        Player player2 = mock(Player.class);
        // Given
        when(player1.getMove()).thenReturn(Optional.of(Move.ROCK)).thenReturn(Optional.empty());
        when(player2.getMove()).thenReturn(Optional.of(Move.ROCK)).thenReturn(Optional.empty());

        RockPaperScissorsGame game = new RockPaperScissorsGame(player1, player2);
        // When
        game.start();

        // Then
        assertTrue(outContent.toString().contains("It's a draw!"));
    }
}
