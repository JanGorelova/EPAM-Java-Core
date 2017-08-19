package sortings.radixsort;

import java.util.Arrays;

public final class RadixSorter {
    /**
     * finds maximum value in the specified array
     *
     * @param array to find max value
     * @return max value in the specified array
     */
    final static int getMax(final int array[]) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    /**
     * puts the number bit numbers in corresponding bucket
     *
     * @param array to be sorted
     * @param value bit number considered
     */
    final static void countSort(final int[] array, final int value) {
        int[] output = new int[array.length];
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (int j = 0; j < array.length; j++) {
            count[(array[j] / value) % 10]++;
        }

        for (int j = 1; j < 10; j++) {
            count[j] += count[j - 1];
        }

        for (int j = array.length - 1; j >= 0; j--) {
            output[count[(array[j] / value) % 10] - 1] = array[j];
            count[(array[j] / value) % 10]--;
        }

        for (int j = 0; j < array.length; j++) {
            array[j] = output[j];
        }
    }

    /**
     * sorts the specified array
     * using the radix sort algorithm
     * complexity in best case
     * in worst case
     *
     * @param array to be sorted
     */
    final static void radixSort(final int[] array) {
        int maxValue = getMax(array);

        for (int exp = 1; maxValue / exp > 0; exp *= 10) {
            countSort(array, exp);
        }
    }

    public final int[] getRadixSortedArray(final int[] array) {
        radixSort(array);

        return array;
    }
}
