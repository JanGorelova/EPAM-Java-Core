package binarysearch;

public final class BinarySearch {
    /**
     * Searches the key value in the array
     *
     * @param key
     * @param array
     * @return index of the element with value = key
     * @throws IllegalArgumentException if there is no such element = key in the array
     */

    public final int search(final int key, final int[] array) {
        int lowIndex = 0;
        int highIndex = array.length - 1;
        int middle;

        while (lowIndex <= highIndex) {
            middle = lowIndex + (highIndex - lowIndex) / 2;

            if (array[middle] > key) {
                highIndex = middle - 1;
            } else if (array[middle] < key) {
                lowIndex = middle + 1;
            } else
                return middle;
        }

        throw new IllegalArgumentException("The key not found!");
    }
}

