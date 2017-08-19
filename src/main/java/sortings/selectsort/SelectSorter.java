package sortings.selectsort;

public final class SelectSorter {
    /**
     * Sorts the specified array in ascending order
     * using the select sort algorithm
     * complexity O(n^2) in average
     *
     * @param array to be sorted
     */
    public final void selectSort(final int[] array) {
        for (int i = 0; i < array.length; i++) {
            swap(i, findIndexOfMinimal(array, i), array);
        }
    }

    /**
     * swap the value with index right and value with index left in specified array
     *
     * @param oneIndex first element to swap index
     * @param twoIndex second element to swap index
     * @param array the elements swap in
     */
    public final void swap(final int oneIndex, final int twoIndex, final int[] array) {
        int temporary = array[oneIndex];

        array[oneIndex] = array[twoIndex];
        array[twoIndex] = temporary;
    }

    /**
     * finds the index of the smallest element in specified array
     *
     * @param array to find minimal element index
     * @param from index to find minimal value from
     * @return the index of the minimal value in array from index from
     */
    public final int findIndexOfMinimal(final int[] array, final int from) {
        int value = array[from];
        int index = from;

        for (int j = from; j < array.length; j++) {
            if (array[j] < value) {
                value = array[j];
                index = j;
            }
        }

        return index;
    }

    public  final int[] getSelectSortedArray(final int[] array) {
        selectSort(array);
        return array;
    }
}

