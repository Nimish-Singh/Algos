package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HouseRobber4Test {
    private final HouseRobber4 hr = new HouseRobber4();
    private int[] nums;

    @Test
    public void sampleInput1() {
        nums = new int[]{2, 3, 5, 9};
        assertEquals(5, hr.minCapability(nums, 2));
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{2, 7, 9, 3, 1};
        assertEquals(2, hr.minCapability(nums, 2));
    }
}
