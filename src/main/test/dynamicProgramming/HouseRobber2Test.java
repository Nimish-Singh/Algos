package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HouseRobber2Test {
    private final HouseRobber2 hr = new HouseRobber2();
    private int[] nums;

    @Test
    public void sampleInput1() {
        nums = new int[]{2, 3, 2};
        assertEquals(3, hr.rob(nums));
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{1, 2, 3, 1};
        assertEquals(4, hr.rob(nums));
    }

    @Test
    public void sampleInput3() {
        nums = new int[]{1, 2, 3};
        assertEquals(3, hr.rob(nums));
    }

    @Test
    public void sampleInput4() {
        nums = new int[]{1, 3, 1, 3, 100};
        assertEquals(103, hr.rob(nums));
    }
}
