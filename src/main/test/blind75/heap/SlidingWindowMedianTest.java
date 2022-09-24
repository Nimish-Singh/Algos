package blind75.heap;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SlidingWindowMedianTest {
    private final SlidingWindowMedian median = new SlidingWindowMedian();

    @Test
    public void sampleInput1() {
        assertArrayEquals(new double[]{1.00000, -1.00000, -1.00000, 3.00000, 5.00000, 6.00000}, median.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3), 0.00000);
    }

    @Test
    public void sampleInput2() {
        assertArrayEquals(new double[]{2.00000, 3.00000, 3.00000, 3.00000, 2.00000, 3.00000, 2.00000}, median.medianSlidingWindow(new int[]{1, 2, 3, 4, 2, 3, 1, 4, 2}, 3), 0.00000);
    }

    @Test
    public void sampleInput3() {
        assertArrayEquals(new double[]{2147483647.00000}, median.medianSlidingWindow(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE}, 2), 0.00000);
    }

    @Test
    public void sampleInput4() {
        assertArrayEquals(new double[]{2.50000}, median.medianSlidingWindow(new int[]{1, 4, 2, 3}, 4), 0.00000);
    }

    @Test
    public void sampleInput5() {
        assertArrayEquals(new double[]{1073741824, 1.50000, 2.50000, 3.50000, 4.50000, 5.50000, 6.50000, 1073741827}, median.medianSlidingWindow(new int[]{2147483647, 1, 2, 3, 4, 5, 6, 7, 2147483647}, 2), 0.00000);
    }
}
