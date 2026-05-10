package com.numbergame;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Round encapsulates a single round of the Number Guessing Game.
 *
 * In each round:
 *  - A random target number is generated within a configured range.
 *  - The player has a limited number of attempts to guess it.
 *  - Hints ("Too High" / "Too Low") are provided after each wrong guess.
 *  - A score is awarded based on how quickly the player guesses correctly.
 */
public class Round {

    // ── Constants ────────────────────────────────────────────────────────────

    /** Lower bound of the random number range (inclusive). */
    public static final int MIN_NUMBER = 1;

    /** Upper bound of the random number range (inclusive). */
    public static final int MAX_NUMBER = 100;

    /** Maximum number of guesses allowed per round. */
    public static final int MAX_ATTEMPTS = 7;

    // ── Fields ───────────────────────────────────────────────────────────────

    /** The secretly generated number the player must guess. */
    private final int targetNumber;

    /** Shared scanner for reading player input. */
    private final Scanner scanner;

    /** The round number (1-based), used for display purposes. */
    private final int roundNumber;

    /** Counts how many guesses the player has made in this round. */
    private int attemptCount;

    // ── Constructor ──────────────────────────────────────────────────────────

    /**
     * Creates a new Round, immediately generating a random target number.
     *
     * @param scanner     the Scanner used to read player input
     * @param roundNumber the 1-based index of this round in the session
     */
    public Round(Scanner scanner, int roundNumber) {
        this.scanner = scanner;
        this.roundNumber = roundNumber;
        this.targetNumber = NumberGenerator.generate(MIN_NUMBER, MAX_NUMBER);
        this.attemptCount = 0;
    }

    // ── Public Methods ───────────────────────────────────────────────────────

    /**
     * Runs this round: prompts the player for guesses, provides hints,
     * and returns the score earned.
     *
     * @return the score for this round (0 if the player didn't guess correctly)
     */
    public int play() {
        System.out.printf("  Guess a number between %d and %d.%n", MIN_NUMBER, MAX_NUMBER);
        System.out.printf("  You have %d attempts.%n%n", MAX_ATTEMPTS);

        while (attemptCount < MAX_ATTEMPTS) {
            int attemptsLeft = MAX_ATTEMPTS - attemptCount;
            System.out.printf("  [Attempt %d/%d] Enter your guess: ",
                    attemptCount + 1, MAX_ATTEMPTS);

            int guess = readGuess();
            attemptCount++;

            if (guess == targetNumber) {
                // ✅ Correct guess
                int score = ScoreCalculator.calculate(attemptCount, MAX_ATTEMPTS);
                System.out.printf("%n  ✅  Correct! The number was %d.%n", targetNumber);
                System.out.printf("  🎉  Round Score: +%d pts  (guessed in %d attempt%s)%n",
                        score, attemptCount, attemptCount == 1 ? "" : "s");
                return score;

            } else if (guess < targetNumber) {
                System.out.println("  📉  Too Low! Try a higher number.");
            } else {
                System.out.println("  📈  Too High! Try a lower number.");
            }

            // Show remaining attempts warning
            int remaining = MAX_ATTEMPTS - attemptCount;
            if (remaining > 0) {
                System.out.printf("      (%d attempt%s remaining)%n%n",
                        remaining, remaining == 1 ? "" : "s");
            }
        }

        // ❌ Player ran out of attempts
        System.out.printf("%n  ❌  Out of attempts! The number was %d. Better luck next round!%n",
                targetNumber);
        return 0;
    }

    // ── Private Helpers ──────────────────────────────────────────────────────

    /**
     * Reads and validates an integer guess from the player.
     * Handles non-integer input gracefully by re-prompting.
     *
     * @return a valid integer entered by the player
     */
    private int readGuess() {
        while (true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine(); // consume trailing newline

                // Validate range
                if (input < MIN_NUMBER || input > MAX_NUMBER) {
                    System.out.printf("  ⚠️  Please enter a number between %d and %d: ",
                            MIN_NUMBER, MAX_NUMBER);
                    continue;
                }
                return input;

            } catch (InputMismatchException e) {
                // Non-integer input — clear the buffer and prompt again
                scanner.nextLine();
                System.out.print("  ⚠️  Invalid input. Enter a whole number: ");
            }
        }
    }
}
