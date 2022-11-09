package slidingWindow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxOnesTest {
    private final MaxOnes m = new MaxOnes();
    private int[] nums;

    @Test
    public void sampleInput1() {
        nums = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        assertEquals(6, m.longestOnes(nums, 2));
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0,0, 1, 1, 1, 1, 1};
        assertEquals(12, m.longestOnes(nums, 4));
    }

    @Test
    public void sampleInput3() {
        nums = new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        assertEquals(10, m.longestOnes(nums, 3));
    }

    @Test
    public void sampleInput4() {
        nums = new int[]{1, 1, 1, 1, 0, 1, 1, 1};
        assertEquals(8, m.longestOnes(nums, 2));
    }
}
