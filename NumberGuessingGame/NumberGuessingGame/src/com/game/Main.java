package com.game;


public class Main {


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
