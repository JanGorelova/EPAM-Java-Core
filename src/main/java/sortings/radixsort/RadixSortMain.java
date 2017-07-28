package sortings.radixsort;

import java.util.Arrays;

public final class RadixSortMain {
    public static void main(String[] args) {
        final int[] array =  new int[] {2,56,89,0,3,55,67,89,21};

        System.out.println(Arrays.toString(array));
        RadixSort.radixSort(array);
        System.out.println(Arrays.toString(array));
    }
}
