package org.example;

import org.example.move.Move;
import org.example.player.Player;
import org.example.round.Round;
import org.example.round.RoundResult;

import java.util.Optional;

public class RockPaperScissorsGame {
    private final Player player1;
    private final Player player2;
    private int player1Wins = 0;
    private int player2Wins = 0;
    private int draws = 0;

    public RockPaperScissorsGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * Starts the Rock-Paper-Scissors game.
     */
    public void start() {
        System.out.println("Welcome to Rock-Paper-Scissors! Please enter \"rock\", \"paper\", \"scissors\", or \"quit\" to exit.");
        while (true) {
            if (!playRound()) {
                System.out.println("Player1 won " + player1Wins + " times and player2 won " + player2Wins + " times. " + draws + " times it was a draw.");
                System.out.println("Thanks for playing! See you again.");
                return;
            }
        }
    }

    private boolean playRound() {
        System.out.println("-------------------------");
        Optional<Move> player1Move = player1.getMove();
        Optional<Move> player2Move = player2.getMove();
        if (player1Move.isEmpty() || player2Move.isEmpty()) {
            return false;
        }
        Round round = new Round(player1Move.get(), player2Move.get());
        RoundResult roundResult = round.evaluateRound();
        updateWinCounts(roundResult);
        return true;
    }

    private void updateWinCounts(RoundResult roundResult) {
        switch (roundResult) {
            case PLAYER1_WIN:
                player1Wins++;
                break;
            case PLAYER2_WIN:
                player2Wins++;
                break;
            case DRAW:
                draws++;
                break;
        }
    }
}
