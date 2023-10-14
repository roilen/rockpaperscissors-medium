package org.example;

import org.example.player.ComputerPlayer;
import org.example.player.HumanPlayer;
import org.example.player.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler(scanner);
        Player humanPlayer = new HumanPlayer(inputHandler);
        Player computerPlayer = new ComputerPlayer();
        RockPaperScissorsGame game = new RockPaperScissorsGame(humanPlayer, computerPlayer);
        game.start();
    }
}
