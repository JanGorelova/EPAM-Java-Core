package sortings.insertsort;

import java.util.Random;

public final class InsertSorter {
    public static void main(String[] args) {
        final int[] array = randomizeFiller(100);
        printArray(array);
        sort(array);
        printArray(array);
    }

    public static void sort(final int[] array) {
        final int N = array.length;

        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && isLess(array[j], array[j - 1]); j--) {
                swap(array, j, j - 1);
            }
        }
    }

    private static void swap(final int[] array, final int indexRight, final int IndexLeft) {
        final int temporary = array[IndexLeft];

        array[IndexLeft] = array[indexRight];
        array[indexRight] = temporary;
    }

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