package leetcode;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContinuousSubarraySumTest {
    private ContinuousSubarraySum sum = new ContinuousSubarraySum();

    @Test
    public void sampleInput1() {
        assertTrue(sum.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
    }

    @Test
    public void sampleInput2() {
        assertTrue(sum.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
    }

    @Test
    public void sampleInput3() {
        assertFalse(sum.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13));
    }

    @Test
    public void sampleInput4() {
        assertFalse(sum.checkSubarraySum(new int[]{1, 2, 12}, 6));
    }

    @Test
    public void sampleInput5() {
        assertTrue(sum.checkSubarraySum(new int[]{5, 0, 0, 0}, 3));
    }
}
