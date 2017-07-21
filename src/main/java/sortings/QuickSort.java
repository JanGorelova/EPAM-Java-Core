package sortings;

import java.io.InputStreamReader;
import java.util.Scanner;

public final class QuickSort<Integer> {
    public static void main(String[] args) {
        final int[] array = arrayReader(25);

        printArray(array);
        doQSort(array, 0, array.length - 1);
        printArray(array);
    }

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

    private static final void doQSort(final int[] array, final int start, final int end) {
        if (start >= end) return;

        int j = partition(array, start, end);

        doQSort(array, start, j - 1);
        doQSort(array, j + 1, end);
    }

    private static final int partition(final int[] array, final int start, final int end) {
        int i = start;
        int j = end + 1;
        int comparableValue = array[start];

        while (true) {
            while (array[++i] < comparableValue) {
                if (i == end) break;
            }
            while (array[--j] > comparableValue) {
                if (j == start) break;
            }
            if (j <= i) break;
            swap(array, i, j);
        }
        swap(array, start, j);
        return j;
    }

    private static final void swap(final int[] array, final int i, final int j) {
        final int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

}
