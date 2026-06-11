package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortArrayByIncreasingFrequencyTest {
    private final SortArrayByIncreasingFrequency sort = new SortArrayByIncreasingFrequency();
    private int[] nums;

    @Test
    public void sampleInput1() {
        nums = new int[]{1, 1, 2, 2, 2, 3};
        assertArrayEquals(new int[]{3, 1, 1, 2, 2, 2}, sort.frequencySort(nums));
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{2, 3, 1, 3, 2};
        assertArrayEquals(new int[]{1, 3, 3, 2, 2}, sort.frequencySort(nums));
    }

    @Test
    public void sampleInput3() {
        nums = new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1};
        assertArrayEquals(new int[]{5, -1, 4, 4, -6, -6, 1, 1, 1}, sort.frequencySort(nums));
    }
}
