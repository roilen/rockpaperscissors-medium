package org.example.move;

public class InvalidMoveException extends IllegalArgumentException {
    public InvalidMoveException(String message) {
        super(message);
    }
}
