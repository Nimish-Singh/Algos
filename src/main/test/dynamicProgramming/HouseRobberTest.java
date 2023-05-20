package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HouseRobberTest {
    private HouseRobber robber = new HouseRobber();
    private int[] nums;

    @Test
    public void sampleInput1() {
        nums = new int[]{1, 2, 3, 1};
        assertEquals(4, robber.rob(nums));
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{2, 7, 9, 3, 1};
        assertEquals(12, robber.rob(nums));
    }

    @Test
    public void sampleInput3() {
        nums = new int[]{114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240};
        assertEquals(4173, robber.rob(nums));
    }
}
