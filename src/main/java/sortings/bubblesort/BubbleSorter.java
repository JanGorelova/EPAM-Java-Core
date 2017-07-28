package sortings.bubblesort;

public final class BubbleSorter {

    public final void bubbleSort(final int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1])
                    swap(j, j + 1, array);
            }
        }
    }

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
