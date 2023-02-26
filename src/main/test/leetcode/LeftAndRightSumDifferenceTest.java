package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class LeftAndRightSumDifferenceTest {
    private final LeftAndRightSumDifference lrd = new LeftAndRightSumDifference();
    private int[] nums;

    @Test
    public void sampleInput1() {
        nums = new int[]{10, 4, 8, 3};
        assertArrayEquals(new int[]{15, 1, 11, 22}, lrd.leftRightDifference(nums));
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{1};
        assertArrayEquals(new int[]{0}, lrd.leftRightDifference(nums));
    }
}
