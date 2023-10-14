package org.example.move;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum Move {
    ROCK,
    PAPER,
    SCISSORS;

    private static final Map<String, Move> STRING_TO_ENUM_MAP = Collections.unmodifiableMap(initializeMap());

    private static Map<String, Move> initializeMap() {
        Map<String, Move> map = new HashMap<>();
        for (Move move : Move.values()) {
            map.put(move.name().toLowerCase(), move);
        }
        return map;
    }

    /**
     * Returns the enum constant of this type with the specified name.
     *
     * @param name the name of the enum constant to be returned.
     * @return Move
     */
    public static Move fromString(String name) {
        Move move = STRING_TO_ENUM_MAP.get(name.toLowerCase());
        if (move == null) {
            throw new InvalidMoveException("Invalid choice: " + name + ". ");
        }
        return move;
    }
}