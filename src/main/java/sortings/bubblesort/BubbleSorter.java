package sortings.bubblesort;

import sortings.ArrayRandom;

public final class BubbleSorter {
    private final ArrayRandom array;

    public BubbleSorter(final ArrayRandom array) {
        this.array = array;
    }

    public final void bubbleSort() {
        for (int i = array.getRandomArray().length - 1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (array.getRandomArray()[j] > array.getRandomArray()[j + 1])
                    swap(j,j+1);
            }
        }
    }

    private final void swap(final int one, final int two) {
        int temporary = array.getRandomArray()[two];

        array.getRandomArray()[two] = array.getRandomArray()[one];
        array.getRandomArray()[one] = temporary;
    }

    public final int[] getSortedArray() {
        bubbleSort();
        return array.getRandomArray();
    }


}
