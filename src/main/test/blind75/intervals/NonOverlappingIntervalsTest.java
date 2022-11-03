package blind75.intervals;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NonOverlappingIntervalsTest {
    private final NonOverlappingIntervals noi = new NonOverlappingIntervals();
    private int[][] intervals;

    @Test
    public void sampleInput1() {
        intervals = new int[][]{{1, 2},
                                {2, 3},
                                {3, 4},
                                {1, 3}};
        assertEquals(1, noi.eraseOverlapIntervals(intervals));
    }

    @Test
    public void sampleInput2() {
        intervals = new int[][]{{1, 2},
                                {1, 2},
                                {1, 2}};
        assertEquals(2, noi.eraseOverlapIntervals(intervals));
    }

    @Test
    public void sampleInput3() {
        intervals = new int[][]{{1, 2},
                                {2, 3}};
        assertEquals(0, noi.eraseOverlapIntervals(intervals));
    }
}
