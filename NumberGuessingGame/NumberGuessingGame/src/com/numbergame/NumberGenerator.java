package com.numbergame;

import java.util.Random;

public class NumberGenerator {

    private static final Random RANDOM = new Random();

    private NumberGenerator() {
        throw new UnsupportedOperationException("NumberGenerator is a utility class.");
    }


    public static int generate(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException(
                    "min (" + min + ") must not be greater than max (" + max + ").");
        }
        // nextInt(n) returns [0, n), so shift by min to get [min, max]
        return RANDOM.nextInt(max - min + 1) + min;
    }
}
