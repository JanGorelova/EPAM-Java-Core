import org.junit.Assert;
import org.junit.Test;
import sortings.insertsort.InsertSort;

import java.util.Arrays;

public final class InsertSortTest {
    @Test
    public void testSort() {
        final int[] array = {8, 7, 6, 5, 4, 3, 2, 1};
        final int[] testArray = Arrays.copyOf(array, array.length);
        Arrays.sort(array, 0, array.length);

        Assert.assertArrayEquals("This method works incorrectly", array, InsertSort.sortTest(testArray));
    }

}
