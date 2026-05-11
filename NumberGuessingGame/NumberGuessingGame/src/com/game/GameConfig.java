package com.game;


public final class GameConfig {




    public static final int MIN_NUMBER = 1;

    public static final int MAX_NUMBER = 100;

    public static final int MAX_ATTEMPTS = 7;

        public static final int TOTAL_ROUNDS = 3;

    // ── Scoring ──────────────────────────────────────────────────────────────

    public static final int BASE_POINTS = 100;

    /** Bonus points earned for each unused attempt when the player wins. */
    public static final int POINTS_PER_REMAINING_ATTEMPT = 10;

    /** Score threshold required to be considered a "great" performance. */
    public static final int GREAT_SCORE_THRESHOLD = 200;

    // ── Private constructor prevents instantiation ────────────────────────────

    private GameConfig() {
        throw new UnsupportedOperationException("GameConfig is a utility class.");
    }
}
