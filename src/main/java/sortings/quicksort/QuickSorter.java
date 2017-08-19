package sortings.quicksort;

import java.io.InputStreamReader;
import java.util.Scanner;

public final class QuickSorter {
    /**
     * reads array from console
     *
     * @param arrayElementsAmount size of the new read array
     * @return new array read from the console
     */
    private static final int[] arrayReader(final int arrayElementsAmount) {
        int[] array = new int[arrayElementsAmount];

        try (final Scanner reader = new Scanner(new InputStreamReader(System.in))) {
            System.out.println("Print the array elements! You have to print: " + arrayElementsAmount + " numbers!");
            for (int i = 0; i < array.length; i++) {
                array[i] = reader.nextInt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    /**
     * prints the specified array in the console
     *
     * @param array to be printed
     */
    private static final void printArray(final int[] array) {
        final StringBuilder builder = new StringBuilder(" [");

        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1) {
                builder.append(array[i]).append(", ");
            } else builder.append(array[i]).append(" ]");
        }
        System.out.println();
        System.out.println(builder);
    }

    /**
     * sorts the specified array from start to end index in the array
     * using the recursive quick sort algorithm
     * complexity in average O(n*log(n))
     *
     * @param array to be sorted
     * @param start index sort from
     * @param end index sort to
     */
    public static final void doQSort(final int[] array, final int start, final int end) {
        if (start >= end) return;

        int putCentralElement = partition(array, start, end);

        doQSort(array, start, putCentralElement - 1);
        doQSort(array, putCentralElement + 1, end);
    }

    /**
     * finda an index of the base element must be
     *
     * @param array to sort
     * @param start index sort from
     * @param end index sort to
     * @return index of the basic element that elements in the right part of the array are bigger than base element
     * and in the left part are smaller
     */
    private static final int partition(final int[] array, final int start, final int end) {
        int indexLeft = start;
        int indexRight = end + 1;
        int comparableValue = array[start];

        while (true) {
            while (array[++indexLeft] < comparableValue) {
                if (indexLeft == end) break;
            }
            while (array[--indexRight] > comparableValue) {
                if (indexRight == start) break;
            }
            if (indexLeft >= indexRight) break;

            swap(array, indexRight, indexLeft);
        }

        swap(array, start, indexRight);
        return indexRight;
    }

    /**
     * swap the value with index right and value with index left in specified array
     *
     * @param indexRight first element to swap index
     * @param indexLeft second element to swap index
     * @param array
     */
    private static final void swap(final int[] array, final int indexRight, final int indexLeft) {
        final int temp = array[indexLeft];

        array[indexLeft] = array[indexRight];
        array[indexRight] = temp;
    }

    /**
     * sorts array and returns it, used in test directory
     *
     * @param array to sort
     * @param start index sort from
     * @param end index sort to
     * @return sorted array
     */
    public static final int[] doQSortTest(final int[] array, final int start, final int end) {
        doQSort(array, start, end);

        return array;
    }
}
