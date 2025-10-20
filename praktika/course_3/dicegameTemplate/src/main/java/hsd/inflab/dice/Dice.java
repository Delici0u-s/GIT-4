package hsd.inflab.dice;

import java.util.Random;

public abstract class Dice {
    private Random random = new Random();

    protected int getRandomNumber(int lowerBound, int upperBound) {
        return random.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }

    public abstract int roll();

    public String getName() {
        return getClass().getSimpleName();
    }

}
