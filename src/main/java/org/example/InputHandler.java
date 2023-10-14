package org.example;

import org.example.move.InvalidMoveException;
import org.example.move.Move;

import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class InputHandler implements AutoCloseable {
    private final Scanner scanner;
    private final static String QUIT_COMMAND = "quit";

    public InputHandler(Scanner scanner) {
        this.scanner = Objects.requireNonNull(scanner, "Scanner must not be null");
    }

    /**
     * Prompts the player to enter the choice of rock scissors or paper to play the round
     * and validates the input.
     *
     * @return The Choice of the player.
     */
    public Optional<Move> getUserMove() {
        while (true) {
            System.out.print("Enter choice (rock, paper, scissors) or 'quit' to quit: ");
            String move = scanner.next();
            if (move.equalsIgnoreCase(QUIT_COMMAND)) {
                return Optional.empty();
            }
            try {
                return Optional.of(Move.fromString(move));
            } catch (InvalidMoveException e) {
                System.out.println(e.getMessage() + "Please try again.");
            }
        }
    }

    @Override
    public void close() {
        scanner.close();
    }
}

