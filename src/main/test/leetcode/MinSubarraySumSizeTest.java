package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinSubarraySumSizeTest {
    private MinSubarraySumSize subarray = new MinSubarraySumSize();

    @Test
    public void sampleInput1() {
        assertEquals(2, subarray.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    @Test
    public void sampleInput2() {
        assertEquals(1, subarray.minSubArrayLen(4, new int[]{1, 4, 4}));
    }

    @Test
    public void sampleInput3() {
        assertEquals(0, subarray.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1}));
    }
}
