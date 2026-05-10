package com.game;

/**
 * Enumerates every possible outcome of a single guess within a round.
 */
public enum GuessResult {

    /** The guess is below the secret number. */
    TOO_LOW,

    /** The guess is above the secret number. */
    TOO_HIGH,

    /** The guess exactly matches the secret number — round won! */
    CORRECT,

    /**
     * The guess was wrong and the player has no attempts left —
     * the round is now over and lost.
     */
    OUT_OF_ATTEMPTS
}
