package com.game;

import java.util.InputMismatchException;
import java.util.Scanner;


public class GameController {


    private final Scanner scanner;

    private final NumberGenerator numberGenerator;

    private final ScoreBoard scoreBoard;

    public GameController() {
        this.scanner         = new Scanner(System.in);
        this.numberGenerator = new NumberGenerator();
        this.scoreBoard      = new ScoreBoard();
    }

    public void startGame() {
        printRules();

        boolean playAgain = true;

        while (playAgain) {
            // Reset score for each full session
            ScoreBoard sessionBoard = new ScoreBoard();

            // ── Round loop ─────────────────────────────────────────────────
            for (int roundNumber = 1; roundNumber <= GameConfig.TOTAL_ROUNDS; roundNumber++) {
                printRoundHeader(roundNumber);
                Round round = new Round(numberGenerator.generate(), GameConfig.MAX_ATTEMPTS);
                playRound(round);
                sessionBoard.recordRound(round.isWon(), round.getPointsEarned());
                printRoundResult(round);
            }


            printSessionSummary(sessionBoard);

            playAgain = askPlayAgain();
        }

        System.out.println("\nThanks for playing! Goodbye! 👋");
        scanner.close();
    }


    private void playRound(Round round) {
        GuessResult result = null;

        // Keep prompting until the round is won or attempts are exhausted
        while (result != GuessResult.CORRECT && result != GuessResult.OUT_OF_ATTEMPTS) {
            int guess = readGuess(round.getAttemptsLeft());
            result    = round.makeGuess(guess);
            printGuessResult(result, round);
        }
    }


    private int readGuess(int attemptsLeft) {
        while (true) {
            System.out.printf(
                "Enter your guess (%d-%d) | Attempts left: %d → ",
                GameConfig.MIN_NUMBER, GameConfig.MAX_NUMBER, attemptsLeft
            );
            try {
                int guess = scanner.nextInt();
                if (guess >= GameConfig.MIN_NUMBER && guess <= GameConfig.MAX_NUMBER) {
                    return guess;
                }
                System.out.printf(
                    "  ⚠  Please enter a number between %d and %d.%n",
                    GameConfig.MIN_NUMBER, GameConfig.MAX_NUMBER
                );
            } catch (InputMismatchException e) {
                // Consume the invalid token so the scanner doesn't loop forever
                scanner.next();
                System.out.println("  ⚠  Invalid input — please enter a whole number.");
            }
        }
    }

    private void printGuessResult(GuessResult result, Round round) {
        switch (result) {
            case TOO_LOW:
                System.out.printf(
                    "  📉 Too low!  Try a higher number.  (%d attempt(s) left)%n",
                    round.getAttemptsLeft()
                );
                break;
            case TOO_HIGH:
                System.out.printf(
                    "  📈 Too high! Try a lower number.   (%d attempt(s) left)%n",
                    round.getAttemptsLeft()
                );
                break;
            case CORRECT:
                System.out.printf(
                    "  ✅ Correct! You found it in %d attempt(s)! +%d points%n",
                    round.getAttemptsMade(), round.getPointsEarned()
                );
                break;
            case OUT_OF_ATTEMPTS:
                System.out.printf(
                    "  ❌ Out of attempts! The number was %d.%n",
                    round.getSecretNumber()
                );
                break;
        }
    }

    /** Prints the result banner at the end of a round. */
    private void printRoundResult(Round round) {
        System.out.println();
        if (round.isWon()) {
            System.out.println("  🎉 Round won! Great job!");
        } else {
            System.out.println("  😔 Round lost. Better luck next time!");
        }
        System.out.println();
    }

    /** Prints the game rules once at the start of the session. */
    private void printRules() {
        System.out.println("┌──────────────────────────────────────┐");
        System.out.println("│              HOW TO PLAY             │");
        System.out.println("├──────────────────────────────────────┤");
        System.out.printf ("│  • Guess a number from %3d to %3d     │%n",
                           GameConfig.MIN_NUMBER, GameConfig.MAX_NUMBER);
        System.out.printf ("│  • You have %d attempts per round     │%n",
                           GameConfig.MAX_ATTEMPTS);
        System.out.printf ("│  • Play %d rounds per session          │%n",
                           GameConfig.TOTAL_ROUNDS);
        System.out.printf ("│  • Base score per win: %3d pts        │%n",
                           GameConfig.BASE_POINTS);
        System.out.printf ("│  • Bonus per unused attempt: %2d pts   │%n",
                           GameConfig.POINTS_PER_REMAINING_ATTEMPT);
        System.out.println("└──────────────────────────────────────┘");
        System.out.println();
    }

    /** Prints the header for the given round number. */
    private void printRoundHeader(int roundNumber) {
        System.out.println("════════════════════════════════════════");
        System.out.printf ("   ROUND %d of %d%n", roundNumber, GameConfig.TOTAL_ROUNDS);
        System.out.println("════════════════════════════════════════");
        System.out.printf(
            "  I'm thinking of a number between %d and %d...%n%n",
            GameConfig.MIN_NUMBER, GameConfig.MAX_NUMBER
        );
    }

    /** Prints the final score summary for the completed session. */
    private void printSessionSummary(ScoreBoard board) {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║           FINAL SCORE CARD           ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println(board.getSummary());
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println();
    }

    private boolean askPlayAgain() {
        System.out.print("Would you like to play again? (y/n): ");
        String answer = scanner.next().trim().toLowerCase();
        System.out.println();
        return answer.equals("y") || answer.equals("yes");
    }
}
