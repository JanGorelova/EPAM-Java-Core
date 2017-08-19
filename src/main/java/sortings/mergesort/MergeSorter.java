package sortings.mergesort;

public final class MergeSorter {
    /**
     * Sorts the specified array in ascending order
     * using the recursive merge algorithm
     * complexity O(n*log(n)), needs O(n) extra memory
     *
     * @param lowerIndex
     * @param upperIndex
     * @param array
     */
    public void mergeSort(final int lowerIndex, final int upperIndex, final int[] array) {

        if (lowerIndex == upperIndex) {
            return;
        } else {
            int middle = (lowerIndex + upperIndex) / 2;

            mergeSort(lowerIndex, middle,array);
            mergeSort(middle + 1, upperIndex,array);

            merge(lowerIndex, middle + 1, upperIndex,array);
        }
    }

    /**
     * merges two arrays in new one in ascending order
     *
     * @param lowerIndex
     * @param split
     * @param upperIndex
     * @param array
     */
    private void merge(final int lowerIndex, final int split, int upperIndex, final int[] array) {
        final int[] mergedValues = new int[upperIndex - lowerIndex + 1];

        int leftIndex = lowerIndex;
        int rightIndex = split + 1;

        int targetIndex = 0;

        while (leftIndex <= split && rightIndex <= upperIndex) {
            if (array[leftIndex] < array[rightIndex]) {
                mergedValues[targetIndex++] = array[leftIndex++];
            } else {
                mergedValues[targetIndex++] = array[rightIndex++];
            }
        }

        while (leftIndex <= split) {
            mergedValues[targetIndex++] = array[leftIndex++];
        }

        while (rightIndex <= upperIndex) {
            mergedValues[targetIndex++] = array[rightIndex++];
        }

        System.arraycopy(mergedValues, 0, array, leftIndex, mergedValues.length);
    }

    public final int[] getSortedArray(final int lowerIndex, final int upperIndex, final int[] array) {
        mergeSort(lowerIndex, upperIndex,array);
        return array;
    }
}
