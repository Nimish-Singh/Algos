package slidingWindow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxSumOfSubarrayTest {
    private MaxSumOfSubarray maxSumOfSubarray = new MaxSumOfSubarray();

    @Test
    public void sampleInput1() {
        assertEquals(9, maxSumOfSubarray.findMaxSumSubArray(3, new int[] {2, 1, 5, 1, 3, 2}));
    }

    @Test
    public void sampleInput2() {
        assertEquals(7, maxSumOfSubarray.findMaxSumSubArray(2, new int[] {2, 3, 4, 1, 5}));
    }
}