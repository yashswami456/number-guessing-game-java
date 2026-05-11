package com.numbergame;

public class ScoreCalculator {

    private static final int BASE_SCORE = 100;

    private static final int PENALTY_PER_ATTEMPT = 15;

    private static final int MIN_SCORE = 10;


    private ScoreCalculator() {
        throw new UnsupportedOperationException("ScoreCalculator is a utility class.");
    }


    public static int calculate(int attemptsUsed, int maxAttempts) {
        int score = BASE_SCORE - (attemptsUsed - 1) * PENALTY_PER_ATTEMPT;
        return Math.max(score, MIN_SCORE);
    }


    public static String getRating(int totalScore, int roundsPlayed) {
        if (roundsPlayed == 0) return "N/A";

        double avg = (double) totalScore / roundsPlayed;

        if (avg >= 90) return "⭐⭐⭐⭐⭐  Legendary!";
        if (avg >= 70) return "⭐⭐⭐⭐    Excellent!";
        if (avg >= 50) return "⭐⭐⭐      Good";
        if (avg >= 25) return "⭐⭐        Fair";
        return            "⭐          Beginner — keep practising!";
    }
}
