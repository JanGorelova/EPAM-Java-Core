package sortings.mergesort;

import sortings.ArrayRandom;

public final class MergeSorter {
    private final ArrayRandom array;

    public MergeSorter(final ArrayRandom array) {
        this.array = array;
    }

    public void mergeSort(final int lowerIndex, final int upperIndex) {

        if (lowerIndex == upperIndex) {
            return;
        } else {
            int middle = (lowerIndex + upperIndex) / 2;

            mergeSort(lowerIndex, middle);
            mergeSort(middle + 1, upperIndex);

            merge(lowerIndex, middle + 1, upperIndex);
        }
    }

    private void merge(final int lowerIndex, final int split, int upperIndex) {
        final int[] mergedValues = new int[upperIndex - lowerIndex + 1];

        int leftIndex = lowerIndex;
        int rightIndex = split + 1;

        int targetIndex = 0;

        while (leftIndex <= split && rightIndex <= upperIndex) {
            if (array.getRandomArray()[leftIndex] < array.getRandomArray()[rightIndex]) {
                mergedValues[targetIndex++] = array.getRandomArray()[leftIndex++];
            } else {
                mergedValues[targetIndex++] = array.getRandomArray()[rightIndex++];
            }
        }

        while (leftIndex <= split) {
            mergedValues[targetIndex++] = array.getRandomArray()[leftIndex++];
        }

        while (rightIndex <= upperIndex) {
            mergedValues[targetIndex++] = array.getRandomArray()[rightIndex++];
        }

        System.arraycopy(mergedValues,0,array.getRandomArray(),leftIndex, mergedValues.length);
    }

    public final int[] getSortedArray(final int lowerIndex, final int upperIndex) {
        mergeSort(lowerIndex,upperIndex);
        return array.getRandomArray();
    }
}
