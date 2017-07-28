import org.junit.Assert;
import org.junit.Test;
import sortings.ArrayRandom;
import sortings.radixsort.RadixSort;

import java.util.Arrays;

public final class RadixSortTest {
    @Test
    public void testSort() {
        final int[] array = new ArrayRandom(25, 45).getRandomArray();
        final int[] testArray = Arrays.copyOf(array, array.length);
        final RadixSort radixSorter = new RadixSort();

        Arrays.sort(array, 0, array.length);

        Assert.assertArrayEquals("This method works incorrectly", array, radixSorter.getRadixSortedArray(testArray));
    }
}
