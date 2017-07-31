import org.junit.Assert;
import org.junit.Test;
import sortings.ArrayRandom;
import sortings.bubblesort.BubbleSorter;
import sortings.insertsort.InsertSorter;
import sortings.mergesort.MergeSorter;

import java.util.Arrays;

public final class MergeSortTest {
    @Test
    public void testSort() {
        final int[] array = new ArrayRandom(25, 45).getRandomArray();
        final int[] testArray = Arrays.copyOf(array, array.length);
        final MergeSorter mergeSorter = new MergeSorter();

        Arrays.sort(array, 0, array.length);

        Assert.assertArrayEquals("This method works incorrectly", array,mergeSorter.getSortedArray(0,testArray.length - 1,testArray));
    }
}
