package sortings.bubblesort;

import java.util.Arrays;

public final class BubbleSorter {
    /**
     * Sorts the specified array in ascending order
     * using the bubble algorithm
     * complexity equals O(n^2)
     *
     * @param array
     */
    public final void bubbleSort(final int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1])
                    swap(j, j + 1, array);
            }
        }
    }

    /**
     * swap the value with index one and value with index two in specified array
     *
     * @param one first element to swap index
     * @param two second element to swap index
     * @param array
     */
    private final void swap(final int one, final int two, final int[] array) {
        int temporary = array[two];

        array[two] = array[one];
        array[one] = temporary;
    }

    public final int[] getSortedArray(final int[] array) {
        bubbleSort(array);
        return array;
    }
}
