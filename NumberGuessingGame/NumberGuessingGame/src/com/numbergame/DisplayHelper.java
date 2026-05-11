package com.numbergame;


public class DisplayHelper {

    public static final String DIVIDER        = "  " + "─".repeat(50);

    public static final String DOUBLE_DIVIDER = "  " + "═".repeat(50);

    private DisplayHelper() {
        throw new UnsupportedOperationException("DisplayHelper is a utility class.");
    }

    public static void printBanner() {
        System.out.println();
        System.out.println(DOUBLE_DIVIDER);
        System.out.println("   🎮  NUMBER GUESSING GAME");
        System.out.println("       Guess the secret number & earn points!");
        System.out.println(DOUBLE_DIVIDER);
        System.out.println("   Range    : 1 – 100");
        System.out.println("   Attempts : " + Round.MAX_ATTEMPTS + " per round");
        System.out.println("   Scoring  : 100 pts  −  15 pts per extra attempt");
        System.out.println("              Minimum 10 pts for a correct guess");
        System.out.println(DOUBLE_DIVIDER);
    }
}
