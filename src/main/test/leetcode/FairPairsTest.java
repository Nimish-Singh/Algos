package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FairPairsTest {
    private final FairPairs fp = new FairPairs();
    private int[] nums;

    @Test
    public void sampleInput1() {
        nums = new int[]{0, 1, 7, 4, 4, 5};
        assertEquals(6, fp.countFairPairs(nums, 3, 6));
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{1, 7, 9, 2, 5};
        assertEquals(1, fp.countFairPairs(nums, 11, 11));
    }
}
