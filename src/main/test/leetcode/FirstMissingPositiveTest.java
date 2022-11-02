package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FirstMissingPositiveTest {
    private final FirstMissingPositive first = new FirstMissingPositive();
    private int[] nums;

    @Test
    public void sampleInput1() {
        nums = new int[]{1, 2, 0};
        assertEquals(3, first.firstMissingPositive(nums));
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{3, 4, -1, 1};
        assertEquals(2, first.firstMissingPositive(nums));
    }

    @Test
    public void sampleInput3() {
        nums = new int[]{7, 8, 9, 11, 12};
        assertEquals(1, first.firstMissingPositive(nums));
    }
}
