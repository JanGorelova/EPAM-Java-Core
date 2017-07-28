package sortings.radixsort;

import java.util.Arrays;

public final class RadixSort {
    final static int getMax(final int array[]) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    final static void countSort(final int[] array, final int exp) {
        int[] output = new int[array.length];
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (int j = 0; j < array.length; j++) {
            count[(array[j] / exp) % 10]++;
        }

        for (int j = 1; j < 10; j++) {
            count[j] += count[j - 1];
        }

        for (int j = 0; j < array.length; j++) {
            array[j] = output[j];
        }
    }

    final static void radixSort(final int[] array) {
        int m = getMax(array);

        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(array,array.length);
        }
    }


}
