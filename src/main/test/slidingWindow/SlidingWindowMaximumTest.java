package slidingWindow;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SlidingWindowMaximumTest {
    public final SlidingWindowMaximum max = new SlidingWindowMaximum();
    private int[] nums;

    @Test
    public void sampleInput1() {
        nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, max.maxSlidingWindow(nums, 3));
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{1};
        assertArrayEquals(new int[]{1}, max.maxSlidingWindow(nums, 1));
    }
}
