package org.example.player;

import org.example.InputHandler;
import org.example.move.Move;

import java.util.Optional;

public class HumanPlayer implements Player {
    private final InputHandler inputHandler;

    public HumanPlayer(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    /**
     * Prompts the player to enter the choice of rock scissors or paper to play the round
     * and validates the input.
     *
     * @return The Choice of the player.
     */
    @Override
    public Optional<Move> getMove() {
        return inputHandler.getUserMove();
    }
}
