package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeleteAndEarnTest {
    private final DeleteAndEarn earn = new DeleteAndEarn();
    private int[] nums;

    @Test
    public void sampleInput1() {
        nums = new int[]{3, 4, 2};
        assertEquals(6, earn.deleteAndEarn(nums));
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{2, 2, 3, 3, 3, 4};
        assertEquals(9, earn.deleteAndEarn(nums));
    }

    @Test
    public void sampleInput3() {
        nums = new int[]{10000};
        assertEquals(10000, earn.deleteAndEarn(nums));
    }
}
