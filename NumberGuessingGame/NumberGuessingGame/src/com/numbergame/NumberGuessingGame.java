package com.numbergame;

import java.util.Scanner;

public class NumberGuessingGame {


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
