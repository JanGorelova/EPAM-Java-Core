package sortings.insertsort;

import java.util.Random;

public final class InsertSorter {
    /**
     * Sorts the specified array in ascending order
     * using the insert algorithm
     * complexity equals O(n^2)
     *
     *@param array
     */
    public static void sort(final int[] array) {
        final int N = array.length;

        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && isLess(array[j], array[j - 1]); j--) {
                swap(array, j, j - 1);
            }
        }
    }

    /**
     * swap the value with index right and value with index left in specified array
     *
     * @param indexRight
     * @param indexLeft
     * @param array
     */
    private static void swap(final int[] array, final int indexRight, final int indexLeft) {
        final int temporary = array[indexLeft];

        array[indexLeft] = array[indexRight];
        array[indexRight] = temporary;
    }

    /**
     * creates a new array with random values
     *
     * @param arraySize
     * @return new array with size arraySize with random values from 0 to 100
     */
    private static int[] randomizeFiller(final int arraySize) {
        final Random random = new Random();
        final int[] array = new int[arraySize];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        return array;
    }

    private static boolean isLess(final Comparable first, final Comparable second) {
        return first.compareTo(second) < 0;
    }

    /**
     * prints array in the console
     *
     * @param array
     */
    private static final void printArray(final int[] array) {
        final StringBuilder builder = new StringBuilder(" [");

        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1) {
                builder.append(array[i]).append(", ");
            } else {builder.append(array[i]).append(" ]");}
        }
        System.out.println();
        System.out.println(builder);
    }

    /**
     * sorts array and return it
     * used in test directory
     *
     * @param array
     * @return sorted array
     */
    public static int[] sortTest(final int[] array) {
        final int n = array.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0 && isLess(array[j], array[j - 1]); j--) {
                swap(array, j, j - 1);
            }
        }

        return array;
    }
}
