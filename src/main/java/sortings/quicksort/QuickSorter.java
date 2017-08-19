package sortings.quicksort;

import java.io.InputStreamReader;
import java.util.Scanner;

public final class QuickSorter {
    /**
     * reads array from console
     *
     * @param arrayElementsAmount
     * @return new array with size @param read from console
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

    public static final void doQSort(final int[] array, final int start, final int end) {
        if (start >= end) return;

        int putCentralElement = partition(array, start, end);

        doQSort(array, start, putCentralElement - 1);
        doQSort(array, putCentralElement + 1, end);
    }

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

    private static final void swap(final int[] array, final int indexRight, final int indexLeft) {
        final int temp = array[indexLeft];

        array[indexLeft] = array[indexRight];
        array[indexRight] = temp;
    }

    public static final int[] doQSortTest(final int[] array, final int start, final int end) {
        doQSort(array, start, end);

        return array;
    }
}
