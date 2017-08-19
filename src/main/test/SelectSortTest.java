import org.junit.Assert;
import org.junit.Test;
import sortings.ArrayRandom;
import sortings.selectsort.SelectSorter;

import java.util.Arrays;

public final class SelectSortTest {
    @Test
    public void testSort() {
        final int[] array = new ArrayRandom(25, 45).getRandomArray();
        final int[] testArray = Arrays.copyOf(array, array.length);
        final SelectSorter selectSorter = new SelectSorter();

        Arrays.sort(array, 0, array.length);

        Assert.assertArrayEquals("This method works incorrectly", array, selectSorter.getSelectSortedArray(testArray));
    }
}
