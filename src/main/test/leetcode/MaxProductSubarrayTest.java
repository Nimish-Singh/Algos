package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxProductSubarrayTest {
    private MaxProductSubarray subarray = new MaxProductSubarray();

    @Test
    public void sampleInput1() {
        assertEquals(6, subarray.maxProduct(new int[]{2, 3, -2, 4}));
    }

    @Test
    public void sampleInput2() {
        assertEquals(0, subarray.maxProduct(new int[]{-2, 0, -1}));
    }
}
