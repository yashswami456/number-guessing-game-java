package com.game;


public class Round {


    private final int secretNumber;

    private final int maxAttempts;

    private int attemptsMade;

    private boolean won;

    private int pointsEarned;


    public Round(int secretNumber, int maxAttempts) {
        this.secretNumber  = secretNumber;
        this.maxAttempts   = maxAttempts;
        this.attemptsMade  = 0;
        this.won           = false;
        this.pointsEarned  = 0;
    }


    public GuessResult makeGuess(int guess) {
        attemptsMade++;

        if (guess == secretNumber) {
            won = true;
            // Award base points + a bonus for each remaining attempt
            int remaining  = maxAttempts - attemptsMade;
            pointsEarned   = GameConfig.BASE_POINTS
                           + (remaining * GameConfig.POINTS_PER_REMAINING_ATTEMPT);
            return GuessResult.CORRECT;
        }

        if (attemptsMade >= maxAttempts) {
            return GuessResult.OUT_OF_ATTEMPTS;
        }

        return (guess < secretNumber) ? GuessResult.TOO_LOW : GuessResult.TOO_HIGH;
    }

    public int getSecretNumber()  { return secretNumber; }

    public int getAttemptsMade()  { return attemptsMade; }

    public int getAttemptsLeft()  { return maxAttempts - attemptsMade; }

    public boolean isWon()        { return won; }

    public int getPointsEarned()  { return pointsEarned; }
}
