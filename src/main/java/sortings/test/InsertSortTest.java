import org.junit.Assert;
import org.junit.Test;
import sortings.InsertSort;

public final class InsertSortTest {
    @Test
    public void testSort() {
        final int[] array = {8,7,6,5,4,3,2,1};
        final int[] sortedArray = {1,2,3,4,5,6,7,8};

        Assert.assertEquals("This method works incorrectly",sortedArray,InsertSort.sortTest(array));
    }

}
