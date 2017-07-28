package sortings.radixsort;

import sortings.ArrayRandom;

import java.util.Arrays;

public final class RadixSortMain {
    public static void main(String[] args) {
        final int[] array = new ArrayRandom(24,67).getRandomArray();

        System.out.println(Arrays.toString(array));
        RadixSort.radixSort(array);
        System.out.println(Arrays.toString(array));
    }
}
