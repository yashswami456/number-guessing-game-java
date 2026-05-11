package com.game;


public class ScoreBoard {

    private int totalScore;

    private int roundsWon;

    private int roundsLost;

    private int roundsPlayed;

    public ScoreBoard() {
        totalScore   = 0;
        roundsWon    = 0;
        roundsLost   = 0;
        roundsPlayed = 0;
    }

    public void recordRound(boolean won, int points) {
        roundsPlayed++;
        if (won) {
            roundsWon++;
            totalScore += points;
        } else {
            roundsLost++;
        }
    }


    public int getTotalScore()   { return totalScore; }

    public int getRoundsWon()    { return roundsWon; }

    public int getRoundsLost()   { return roundsLost; }

    public int getRoundsPlayed() { return roundsPlayed; }

    public double getWinPercentage() {
        if (roundsPlayed == 0) return 0.0;
        return ((double) roundsWon / roundsPlayed) * 100.0;
    }

    public String getPerformanceRating() {
        if (totalScore >= GameConfig.GREAT_SCORE_THRESHOLD * 2) return "Excellent \uD83C\uDFC6";
        if (totalScore >= GameConfig.GREAT_SCORE_THRESHOLD)     return "Great \uD83C\uDF1F";
        if (totalScore > 0)                                      return "Good \uD83D\uDC4D";
        return "Keep Practising \uD83D\uDCAA";
    }

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
