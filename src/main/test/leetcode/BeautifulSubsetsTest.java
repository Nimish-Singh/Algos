package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BeautifulSubsetsTest {
    private final BeautifulSubsets subsets = new BeautifulSubsets();
    private int[] nums;

    @Test
    public void sampleInput1() {
        nums = new int[]{2, 4, 6};
        assertEquals(4, subsets.beautifulSubsets(nums, 2));
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{1};
        assertEquals(1, subsets.beautifulSubsets(nums, 1));
    }
}
