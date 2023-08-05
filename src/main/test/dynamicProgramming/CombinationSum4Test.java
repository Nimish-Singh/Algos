package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CombinationSum4Test {
    private final CombinationSum4 c = new CombinationSum4();
    private int[] nums;

    @Test
    public void sampleInput1() {
        nums = new int[]{1, 2, 3};
        assertEquals(7, c.combinationSum4(nums, 4));
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{9};
        assertEquals(0, c.combinationSum4(nums, 3));
    }
}
