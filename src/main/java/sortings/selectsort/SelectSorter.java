package sortings.selectsort;

public final class SelectSorter {
    public final void selectSort(final int[] array) {
        for (int i = 0; i < array.length; i++) {
            swap(i, findIndexOfMinimal(array, i), array);
        }
    }

    public final void swap(final int oneIndex, final int twoIndex, final int[] array) {
        int temporary = array[oneIndex];

        array[oneIndex] = array[twoIndex];
        array[twoIndex] = temporary;
    }

    public final int findIndexOfMinimal(final int[] array, final int i) {
        int value = array[i];
        int index = i;

        for (int j = i; j < array.length; j++) {
            if (array[j] < value) {
                value = array[j];
                index = j;
            }
        }

        return index;
    }

    public  final int[] getSelectSortedAray(final int[] array) {
        selectSort(array);
        return array;
    }
}

