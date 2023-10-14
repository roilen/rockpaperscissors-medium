package org.example.player;

import org.example.move.Move;

import java.util.Optional;

public interface Player {
    Optional<Move> getMove();
}
