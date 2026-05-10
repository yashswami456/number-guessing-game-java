package com.numbergame;

/**
 * ScoreCalculator is a stateless utility class that computes round scores
 * and overall performance ratings.
 *
 * <h2>Scoring Formula</h2>
 * The score rewards guessing quickly:
 * <pre>
 *   score = BASE_SCORE - (attemptsUsed - 1) * PENALTY_PER_ATTEMPT
 * </pre>
 * The minimum score for a correct guess is {@code MIN_SCORE}.
 * A score of 0 is awarded only when the player fails to guess the number.
 *
 * <h2>Rating Thresholds (per round, higher is better)</h2>
 * <ul>
 *   <li>⭐⭐⭐⭐⭐ Legendary   — avg ≥ 90 pts</li>
 *   <li>⭐⭐⭐⭐   Excellent   — avg ≥ 70 pts</li>
 *   <li>⭐⭐⭐    Good        — avg ≥ 50 pts</li>
 *   <li>⭐⭐      Fair        — avg ≥ 25 pts</li>
 *   <li>⭐        Beginner    — avg &lt; 25 pts</li>
 * </ul>
 */
public class ScoreCalculator {

    // ── Scoring Constants ────────────────────────────────────────────────────

    /** Base score awarded for guessing correctly on the first attempt. */
    private static final int BASE_SCORE = 100;

    /** Points deducted for each additional attempt beyond the first. */
    private static final int PENALTY_PER_ATTEMPT = 15;

    /** Minimum score awarded for any correct guess (no matter how many attempts). */
    private static final int MIN_SCORE = 10;

    /**
     * Private constructor — utility class, not meant to be instantiated.
     */
    private ScoreCalculator() {
        throw new UnsupportedOperationException("ScoreCalculator is a utility class.");
    }

    // ── Public Methods ───────────────────────────────────────────────────────

    /**
     * Calculates the score for a successful guess.
     *
     * @param attemptsUsed the number of attempts the player took (≥ 1)
     * @param maxAttempts  the maximum attempts allowed (used for validation context)
     * @return the score earned, always between {@code MIN_SCORE} and {@code BASE_SCORE}
     */
    public static int calculate(int attemptsUsed, int maxAttempts) {
        int score = BASE_SCORE - (attemptsUsed - 1) * PENALTY_PER_ATTEMPT;
        return Math.max(score, MIN_SCORE);
    }

    /**
     * Returns a descriptive performance rating based on average score per round.
     *
     * @param totalScore   the cumulative score across all rounds
     * @param roundsPlayed the number of rounds completed
     * @return a human-readable rating string with emoji stars
     */
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
