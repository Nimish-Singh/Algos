package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinTimeCellInGridTest {
    private final MinTimeCellInGrid mt = new MinTimeCellInGrid();
    private int[][] grid;

    @Test
    public void sampleInput1() {
        grid = new int[][]{{0, 1, 3, 2},
                           {5, 1, 2, 5},
                           {4, 3, 8, 6}};
        assertEquals(7, mt.minimumTime(grid));
    }

    @Test
    public void sampleInput2() {
        grid = new int[][]{{0, 2, 4},
                           {3, 2, 1},
                           {1, 0, 4}};
        assertEquals(-1, mt.minimumTime(grid));
    }
}
