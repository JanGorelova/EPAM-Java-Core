package sortings;

import java.util.Random;

public final class InsertSort {
    public static void main(String[] args) {

    }

    private static void sort(final int[] array) {

    }

    private static void swap(final int[] array, final int i, final int j) {
        final int temporary = array[j];

        array[j] = array[i];
        array[i] = temporary;
    }

    private static int[] randomizeFiller(final int arraySize) {
        final Random random = new Random();
        final int[] array = new int[arraySize];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        return array;
    }
}
