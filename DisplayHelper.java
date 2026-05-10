package com.numbergame;

/**
 * DisplayHelper provides reusable console-output utilities:
 * decorative dividers, the welcome banner, and any other
 * shared formatting constants used across the game.
 */
public class DisplayHelper {

    // ── Decorative Constants ─────────────────────────────────────────────────

    /** Single-line divider for round separators. */
    public static final String DIVIDER        = "  " + "─".repeat(50);

    /** Double-line divider for major section headers (e.g., final results). */
    public static final String DOUBLE_DIVIDER = "  " + "═".repeat(50);

    /**
     * Private constructor — utility class, not meant to be instantiated.
     */
    private DisplayHelper() {
        throw new UnsupportedOperationException("DisplayHelper is a utility class.");
    }

    // ── Public Methods ───────────────────────────────────────────────────────

    /**
     * Prints the ASCII welcome banner shown at game startup.
     */
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
