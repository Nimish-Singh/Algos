package slidingWindow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxSumNonOverlappingArraysTest {
    private final MaxSumNonOverlappingArrays maxSum = new MaxSumNonOverlappingArrays();
    private int[] nums;

    @Test
    public void sampleInput1() {
        nums = new int[]{0, 6, 5, 2, 2, 5, 1, 9, 4};
        assertEquals(20, maxSum.maxSumTwoNoOverlap(nums, 1, 2));
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{3, 8, 1, 3, 2, 1, 8, 9, 0};
        assertEquals(29, maxSum.maxSumTwoNoOverlap(nums, 3, 2));
    }

    @Test
    public void sampleInput3() {
        nums = new int[]{2, 1, 5, 6, 0, 9, 5, 0, 3, 8};
        assertEquals(31, maxSum.maxSumTwoNoOverlap(nums, 4, 3));
    }
}
