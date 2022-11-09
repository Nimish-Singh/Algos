package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AverageValueTest {
    private final AverageValue avg = new AverageValue();
    private int[] nums;

    @Test
    public void sampleInput1() {
        nums = new int[]{1, 3, 6, 10, 12, 15};
        assertEquals(9, avg.averageValue(nums));
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{1, 2, 4, 7, 10};
        assertEquals(0, avg.averageValue(nums));
    }
}
