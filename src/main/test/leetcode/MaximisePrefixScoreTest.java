package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximisePrefixScoreTest {
    private final MaximisePrefixScore max = new MaximisePrefixScore();
    private int[] nums;

    @Test
    public void sampleInput1() {
        nums = new int[]{2, -1, 0, 1, -3, 3, -3};
        assertEquals(6, max.maxScore(nums));
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{-2, -3, 0};
        assertEquals(0, max.maxScore(nums));
    }

    @Test
    public void sampleInput3() {
        nums = new int[]{-2, -3, -4, -8};
        assertEquals(0, max.maxScore(nums));
    }

    @Test
    public void sampleInput4() {
        nums = new int[]{-687767, -860350, 950296, 52109, 510127, 545329, -291223, -966728, 852403, 828596, 456730, -483632, -529386, 356766, 147293, 572374, 243605, 931468, 641668, 494446};
        assertEquals(20, max.maxScore(nums));
    }
}
