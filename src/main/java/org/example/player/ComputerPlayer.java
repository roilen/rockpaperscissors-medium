package org.example.player;

import org.example.move.Move;

import java.util.Optional;
import java.util.Random;


public class ComputerPlayer implements Player {
    private static final Random RANDOM = new Random();
    /**
     * Generates the random move for the computer player from the available options in Move Enum.
     *
     * @return Move
     */
    @Override
    public Optional<Move> getMove() {
        return Optional.of(Move.values()[RANDOM.nextInt(Move.values().length)]);
    }
}
