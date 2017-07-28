package sortings;

import java.util.Arrays;
import java.util.Random;

public final class ArrayRandom {
    private final int[] randomizedArray;

    public ArrayRandom(final int size, final int randomBorder) {
        this.randomizedArray = new int[size];
        for (int i = 0; i < size; i++) {
            randomizedArray[i] = getRandomValue(randomBorder);
        }
    }

    private int getRandomValue(final int randomBorder) {
        final Random random = new Random();

        return random.nextInt(randomBorder);
    }

    public final int[] getRandomArray() {
        return randomizedArray;
    }

    public final String printArray() {
        return Arrays.toString(randomizedArray);
    }
}
