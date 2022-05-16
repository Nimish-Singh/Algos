package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JumpGame2Test {
    private JumpGame2 jg = new JumpGame2();

    @Test
    public void sampleInput1() {
        int[] nums = new int[] {2, 3, 1, 1, 4};
        assertEquals(2, jg.jump(nums));
    }

    @Test
    public void sampleInput2() {
        int[] nums = new int[]{2, 3, 0, 1, 4};
        assertEquals(2, jg.jump(nums));
    }
}
