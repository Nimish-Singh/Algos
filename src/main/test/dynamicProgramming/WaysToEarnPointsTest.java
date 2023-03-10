package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WaysToEarnPointsTest {
    private final WaysToEarnPoints ways = new WaysToEarnPoints();
    private int[][] types;

    @Test
    public void sampleInput1() {
        types = new int[][]{{6, 1},
                            {3, 2},
                            {2, 3}};
        assertEquals(7, ways.waysToReachTarget(6, types));
    }

    @Test
    public void sampleInput2() {
        types = new int[][]{{50, 1},
                            {50, 2},
                            {50, 5}};
        assertEquals(4, ways.waysToReachTarget(5, types));
    }

    @Test
    public void sampleInput3() {
        types = new int[][]{{6, 1},
                            {3, 2},
                            {2, 3}};
        assertEquals(1, ways.waysToReachTarget(18, types));
    }
}
