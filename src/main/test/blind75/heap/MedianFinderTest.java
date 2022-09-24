package blind75.heap;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MedianFinderTest {
    private final MedianFinder medianFinder = new MedianFinder();

    @Test
    public void sampleInput1() {
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        assertEquals(1.5, medianFinder.findMedian(), 0.0);

        medianFinder.addNum(3);
        assertEquals(2.0, medianFinder.findMedian(), 0.0);
    }
}
