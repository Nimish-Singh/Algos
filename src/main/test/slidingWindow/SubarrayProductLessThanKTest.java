package slidingWindow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubarrayProductLessThanKTest {
    private final SubarrayProductLessThanK subarray = new SubarrayProductLessThanK();
    private int[] nums;

    @Test
    public void sampleInput1() {
        nums = new int[]{10, 5, 2, 6};
        assertEquals(8, subarray.numSubarrayProductLessThanK(nums, 100));
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{1, 2, 3};
        assertEquals(0, subarray.numSubarrayProductLessThanK(nums, 0));
    }
}
