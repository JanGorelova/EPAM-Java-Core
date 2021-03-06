import org.junit.Assert;
import org.junit.Test;
import sortings.ArrayRandom;
import sortings.insertsort.InsertSorter;

import java.util.Arrays;

public final class InsertSortTest {
    @Test
    public void testSort() {
        final int[] array = new ArrayRandom(25, 45).getRandomArray();
        final int[] testArray = Arrays.copyOf(array, array.length);
        Arrays.sort(array, 0, array.length);

        Assert.assertArrayEquals("This method works incorrectly", array, InsertSorter.sortTest(testArray));
    }
}
