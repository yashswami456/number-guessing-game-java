package com.numbergame;

import java.util.Random;

/**
 * NumberGenerator is a stateless utility class responsible for
 * generating random integers within a specified range.
 *
 * Using a single shared {@link Random} instance avoids the overhead
 * of creating a new object for every round.
 */
public class NumberGenerator {

    /** Shared Random instance — thread-safe enough for single-threaded use. */
    private static final Random RANDOM = new Random();

    /**
     * Private constructor — this is a utility class and should not be instantiated.
     */
    private NumberGenerator() {
        throw new UnsupportedOperationException("NumberGenerator is a utility class.");
    }

    // ── Public Methods ───────────────────────────────────────────────────────

    /**
     * Generates a random integer between {@code min} and {@code max} (both inclusive).
     *
     * @param min the lower bound (inclusive)
     * @param max the upper bound (inclusive)
     * @return a random integer in the range [min, max]
     * @throws IllegalArgumentException if {@code min} is greater than {@code max}
     */
    public static int generate(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException(
                    "min (" + min + ") must not be greater than max (" + max + ").");
        }
        // nextInt(n) returns [0, n), so shift by min to get [min, max]
        return RANDOM.nextInt(max - min + 1) + min;
    }
}
