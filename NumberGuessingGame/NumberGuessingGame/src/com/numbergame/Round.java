package com.numbergame;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Round {


    public static final int MIN_NUMBER = 1;


    public static final int MAX_NUMBER = 100;

    public static final int MAX_ATTEMPTS = 7;


    private final int targetNumber;

    private final Scanner scanner;

    private final int roundNumber;

    private int attemptCount;

    public Round(Scanner scanner, int roundNumber) {
        this.scanner = scanner;
        this.roundNumber = roundNumber;
        this.targetNumber = NumberGenerator.generate(MIN_NUMBER, MAX_NUMBER);
        this.attemptCount = 0;
    }

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
