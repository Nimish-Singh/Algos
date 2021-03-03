package slidingWindow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SmallestSubarrayWithGivenSumTest {
    private SmallestSubarrayWithGivenSum smallestSubarrayWithGivenSum = new SmallestSubarrayWithGivenSum();

    @Test
    public void sampleInput1() {
        assertEquals(2, smallestSubarrayWithGivenSum.findMinSubArrayLength(7, new int[] {2, 1, 5, 2, 3, 2}));
    }

    @Test
    public void sampleInput2() {
        assertEquals(1, smallestSubarrayWithGivenSum.findMinSubArrayLength(7, new int[] {2, 1, 5, 2, 8}));
    }

    @Test
    public void sampleInput3() {
        assertEquals(3, smallestSubarrayWithGivenSum.findMinSubArrayLength(8, new int[] {3, 4, 1, 1, 6}));
    }
}
