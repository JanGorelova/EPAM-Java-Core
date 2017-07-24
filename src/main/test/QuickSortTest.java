import org.junit.Assert;
import org.junit.Test;
import sortings.qiucksort.QuickSort;

import java.util.Arrays;

public final class QuickSortTest {
    @Test
    public void testSort() {
        final int[] array = new int[]{1, 5, 6, 7, 78, 9, 9, 0, 7, 3, 2, 1};
        final int[] testArray = Arrays.copyOf(array, array.length);
        Arrays.sort(array, 0, array.length);

        Assert.assertArrayEquals("This method works incorrectly", array, QuickSort.doQSortTest(testArray, 0, testArray.length - 1));
    }
}
