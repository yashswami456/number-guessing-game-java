package com.numbergame;

import java.util.Scanner;

/**
 * GameEngine handles the overall game flow, including:
 * - Managing multiple rounds
 * - Tracking cumulative score across rounds
 * - Deciding whether the player wants to continue
 */
public class GameEngine {

    // ── Constants ────────────────────────────────────────────────────────────

    /** Default number of rounds to play in a session. */
    private static final int DEFAULT_ROUNDS = 3;

    // ── Fields ───────────────────────────────────────────────────────────────

    /** Shared scanner for reading player input. */
    private final Scanner scanner;

    /** Cumulative score across all rounds. */
    private int totalScore;

    /** Number of rounds played so far. */
    private int roundsPlayed;

    // ── Constructor ──────────────────────────────────────────────────────────

    /**
     * Creates a new GameEngine.
     *
     * @param scanner the Scanner used to read player input
     */
    public GameEngine(Scanner scanner) {
        this.scanner = scanner;
        this.totalScore = 0;
        this.roundsPlayed = 0;
    }

    // ── Public Methods ───────────────────────────────────────────────────────

    /**
     * Starts the game session.
     * Plays through the configured number of rounds, then shows the final summary.
     */
    public void start() {
        System.out.println("\nYou will play " + DEFAULT_ROUNDS + " rounds.");
        System.out.println("Try to guess the number in as few attempts as possible!");
        System.out.println(DisplayHelper.DIVIDER);

        // Play each round sequentially
        for (int round = 1; round <= DEFAULT_ROUNDS; round++) {
            System.out.println("\n🎯  ROUND " + round + " of " + DEFAULT_ROUNDS);
            System.out.println(DisplayHelper.DIVIDER);

            Round currentRound = new Round(scanner, round);
            int roundScore = currentRound.play();

            totalScore += roundScore;
            roundsPlayed++;

            // Show running score after each round (except the last)
            if (round < DEFAULT_ROUNDS) {
                System.out.printf("%n  Running Score: %d pts  |  Rounds Left: %d%n",
                        totalScore, DEFAULT_ROUNDS - round);
            }
        }

        // Display final summary after all rounds
        displayFinalSummary();
    }

    // ── Private Helpers ──────────────────────────────────────────────────────

    /**
     * Displays the final game summary with total score and performance rating.
     */
    private void displayFinalSummary() {
        System.out.println("\n" + DisplayHelper.DOUBLE_DIVIDER);
        System.out.println("           🏆  GAME OVER — FINAL RESULTS  🏆");
        System.out.println(DisplayHelper.DOUBLE_DIVIDER);
        System.out.printf("  Rounds Played : %d%n", roundsPlayed);
        System.out.printf("  Total Score   : %d pts%n", totalScore);
        System.out.printf("  Performance   : %s%n", ScoreCalculator.getRating(totalScore, roundsPlayed));
        System.out.println(DisplayHelper.DOUBLE_DIVIDER);
    }
}
