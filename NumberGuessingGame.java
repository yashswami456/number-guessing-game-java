package com.numbergame;

import java.util.Scanner;

/**
 * NumberGuessingGame - Main entry point for the Number Guessing Game.
 *
 * This game challenges the player to guess a randomly generated number
 * within a limited number of attempts across multiple rounds.
 * A score is calculated based on performance in each round.
 *
 * @author  Your Name
 * @version 1.0
 */
public class NumberGuessingGame {

    /**
     * Main method — launches the game.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameEngine engine = new GameEngine(scanner);

        // Display welcome banner
        DisplayHelper.printBanner();

        // Start the main game loop
        engine.start();

        System.out.println("\nThanks for playing! Goodbye! 👋");
        scanner.close();
    }
}
