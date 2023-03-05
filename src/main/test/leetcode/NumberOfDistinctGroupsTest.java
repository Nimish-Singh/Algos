package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfDistinctGroupsTest {
    private final NumberOfDistinctGroups dg = new NumberOfDistinctGroups();
    private int[] nums;

    @Test
    public void sampleInput1() {
        nums = new int[]{1, 2, 3, 4, 1, 5, 6, 4, 2, 2, 2, 6, 7};
        assertEquals(4, dg.minGroups(nums, 5));
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{2, 2, 3, 4, 1, 5, 6, 4, 2, 2, 2, 6, 7};
        assertEquals(5, dg.minGroups(nums, 5));
    }
}
