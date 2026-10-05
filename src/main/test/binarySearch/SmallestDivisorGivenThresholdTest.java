package binarySearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SmallestDivisorGivenThresholdTest {
    private final SmallestDivisorGivenThreshold divisor = new SmallestDivisorGivenThreshold();
    private int[] nums;

    @Test
    public void sampleInput1() {
        nums = new int[]{1, 2, 5, 9};
        assertEquals(5, divisor.smallestDivisor(nums, 6));
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{44, 22, 33, 11, 1};
        assertEquals(44, divisor.smallestDivisor(nums, 5));
    }
}
