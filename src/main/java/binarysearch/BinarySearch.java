package binarysearch;

public final class BinarySearch {
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

