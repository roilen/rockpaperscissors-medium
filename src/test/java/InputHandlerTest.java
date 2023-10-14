import org.example.InputHandler;
import org.example.move.Move;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Optional;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class InputHandlerTest {

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
    public void testValidInput() {
        ByteArrayInputStream in = new ByteArrayInputStream("rock".getBytes());
        Scanner scanner = new Scanner(in);
        InputHandler handler = new InputHandler(scanner);

        Optional<Move> result = handler.getUserMove();

        assertTrue(result.isPresent());
        assertEquals(Move.ROCK, result.get());
    }

    @Test
    public void testInvalidInputFollowedByValidInput() {
        String data = "invalid\nrock";
        ByteArrayInputStream in = new ByteArrayInputStream(data.getBytes());
        Scanner scanner = new Scanner(in);
        InputHandler handler = new InputHandler(scanner);

        Optional<Move> result = handler.getUserMove();

        assertTrue(result.isPresent());
        assertEquals(Move.ROCK, result.get());
        assertTrue(outContent.toString().contains("Invalid choice: invalid. Please try again."));
    }

    @Test
    public void testQuitCommand() {
        ByteArrayInputStream in = new ByteArrayInputStream("quit".getBytes());
        Scanner scanner = new Scanner(in);
        InputHandler handler = new InputHandler(scanner);

        Optional<Move> result = handler.getUserMove();

        assertFalse(result.isPresent());
    }

}
