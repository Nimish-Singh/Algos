package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestIncreasingSubsequenceTest {
    private final LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
    private int[] nums;

    @Test
    public void sampleInput1() {
        nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        assertEquals(4, lis.lengthOfLIS(nums));
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{0, 1, 0, 3, 2, 3};
        assertEquals(4, lis.lengthOfLIS(nums));
    }

    @Test
    public void sampleInput3() {
        nums = new int[]{7, 7, 7, 7, 7, 7, 7};
        assertEquals(1, lis.lengthOfLIS(nums));
    }
}
