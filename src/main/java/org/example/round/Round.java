package org.example.round;

import org.example.move.Move;

import java.util.HashMap;
import java.util.Map;

public class Round {
    private final Move player1Move;
    private final Move player2Move;

    private static final Map<Move, Move> WINNING_CHOICES = new HashMap<>() {{
        put(Move.ROCK, Move.SCISSORS);
        put(Move.PAPER, Move.ROCK);
        put(Move.SCISSORS, Move.PAPER);
    }};

    public Round(Move player1Move, Move player2Move) {
        this.player1Move = player1Move;
        this.player2Move = player2Move;
    }

    /**
     * Determines the winner of the round.
     *
     * @return RoundResult
     */
    public RoundResult evaluateRound() {
        System.out.println("Player1 chose " + player1Move);
        System.out.println("Player2 chose " + player2Move);
        if (player1Move.equals(player2Move)) {
            System.out.println("It's a draw!");
            return RoundResult.DRAW;
        } else if (WINNING_CHOICES.get(player1Move).equals(player2Move)) {
            System.out.println("Player1 wins!");
            return RoundResult.PLAYER1_WIN;
        } else {
            System.out.println("Player2 wins!");
            return RoundResult.PLAYER2_WIN;
        }
    }
}
