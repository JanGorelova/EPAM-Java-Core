package sortings;

import sortings.bubblesort.BubbleSorter;
import sortings.mergesort.MergeSorter;

import java.util.Arrays;

public final class TestSorter {
    public static void main(String[] args) {
        final ArrayRandom array = new ArrayRandom(100,100);
        final BubbleSorter bubbleSorter= new BubbleSorter();
        final MergeSorter mergeSorter = new MergeSorter(array);

        System.out.println(array);
        array.printArray();
        System.out.println(array.printArray());

        final int[] bubbleResult = bubbleSorter.getSortedArray(array.getRandomArray());
        final int[] mergeResult = mergeSorter.getSortedArray(0,99);

        System.out.println(Arrays.toString(bubbleResult));
    }
}
