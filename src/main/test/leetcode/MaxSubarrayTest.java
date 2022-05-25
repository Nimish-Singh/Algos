package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxSubarrayTest {
    private MaxSubarray ms = new MaxSubarray();

    @Test
    public void sampleInput1() {
        assertEquals(6, ms.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    @Test
    public void sampleInput2() {
        assertEquals(1, ms.maxSubArray(new int[]{1}));
    }

    @Test
    public void sampleInput3() {
        assertEquals(-1, ms.maxSubArray(new int[]{-1}));
    }

    @Test
    public void sampleInput4() {
        assertEquals(23, ms.maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }
}
