package com.game;

/**
 * Tracks and summarises the player's score across all rounds of the game.
 *
 * <p>Call {@link #recordRound(boolean, int)} after each round completes, then
 * use the accessor methods to query session statistics at any time.
 */
public class ScoreBoard {

    // ── Fields ───────────────────────────────────────────────────────────────

    /** Running total of all points earned across won rounds. */
    private int totalScore;

    /** Number of rounds the player has won. */
    private int roundsWon;

    /** Number of rounds the player has lost. */
    private int roundsLost;

    /** Total number of rounds played (won + lost). */
    private int roundsPlayed;

    // ── Constructor ──────────────────────────────────────────────────────────

    /** Creates a fresh score board with all counters at zero. */
    public ScoreBoard() {
        totalScore   = 0;
        roundsWon    = 0;
        roundsLost   = 0;
        roundsPlayed = 0;
    }

    // ── Mutators ─────────────────────────────────────────────────────────────

    /**
     * Records the outcome of a completed round.
     *
     * @param won    {@code true} if the player guessed correctly
     * @param points Points earned this round (ignored when {@code won} is false)
     */
    public void recordRound(boolean won, int points) {
        roundsPlayed++;
        if (won) {
            roundsWon++;
            totalScore += points;
        } else {
            roundsLost++;
        }
    }

    // ── Accessors ────────────────────────────────────────────────────────────

    /** @return Cumulative points across all won rounds. */
    public int getTotalScore()   { return totalScore; }

    /** @return Number of rounds won. */
    public int getRoundsWon()    { return roundsWon; }

    /** @return Number of rounds lost. */
    public int getRoundsLost()   { return roundsLost; }

    /** @return Total rounds played so far. */
    public int getRoundsPlayed() { return roundsPlayed; }

    // ── Derived stats ────────────────────────────────────────────────────────

    /**
     * Calculates the player's win rate as a percentage.
     *
     * @return Win percentage rounded to one decimal place, or 0.0 if no rounds played
     */
    public double getWinPercentage() {
        if (roundsPlayed == 0) return 0.0;
        return ((double) roundsWon / roundsPlayed) * 100.0;
    }

    /**
     * Returns a human-readable performance rating based on the total score.
     *
     * @return One of: "Excellent 🏆", "Great 🌟", "Good 👍", or "Keep Practising 💪"
     */
    public String getPerformanceRating() {
        if (totalScore >= GameConfig.GREAT_SCORE_THRESHOLD * 2) return "Excellent \uD83C\uDFC6";
        if (totalScore >= GameConfig.GREAT_SCORE_THRESHOLD)     return "Great \uD83C\uDF1F";
        if (totalScore > 0)                                      return "Good \uD83D\uDC4D";
        return "Keep Practising \uD83D\uDCAA";
    }

    /**
     * Returns a formatted summary suitable for printing to the console.
     *
     * @return Multi-line score summary string
     */
    public String getSummary() {
        return String.format(
            "  Rounds Played : %d%n"
          + "  Rounds Won    : %d%n"
          + "  Rounds Lost   : %d%n"
          + "  Win Rate      : %.1f%%%n"
          + "  Total Score   : %d%n"
          + "  Performance   : %s",
            roundsPlayed,
            roundsWon,
            roundsLost,
            getWinPercentage(),
            totalScore,
            getPerformanceRating()
        );
    }
}
