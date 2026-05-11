package com.game;

import java.util.Random;


public class NumberGenerator {


    private final Random random;

    public NumberGenerator() {
        this.random = new Random();
    }



    public int generate() {
        int range = GameConfig.MAX_NUMBER - GameConfig.MIN_NUMBER + 1;
        return GameConfig.MIN_NUMBER + random.nextInt(range);
    }
}
