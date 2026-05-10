package com.game;

/**
 * Main entry point for the Number Guessing Game.
 *
 * This class bootstraps the application by creating a GameController
 * instance and starting the game loop.
 *
 * @author  Number Guessing Game
 * @version 1.0
 */
public class Main {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║      NUMBER GUESSING GAME  v1.0      ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println();

        // Create and start the game controller
        GameController controller = new GameController();
        controller.startGame();
    }
}
