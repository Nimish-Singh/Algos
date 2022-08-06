package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubarraySumKTest {
    private SubarraySumK sk = new SubarraySumK();

    @Test
    public void sampleInput1() {
        assertEquals(2, sk.subarraySum(new int[]{1, 1, 1}, 2));
    }

    @Test
    public void sampleInput2() {
        assertEquals(2, sk.subarraySum(new int[]{1, 2, 3}, 3));
    }
}
