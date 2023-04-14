package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class KnightTourConfigTest {
    private final KnightTourConfig ktc = new KnightTourConfig();
    private int[][] grid;

    @Test
    public void sampleInput1() {
        grid = new int[][]{{0, 11, 16, 5, 20},
                           {17, 4, 19, 10, 15},
                           {12, 1, 8, 21, 6},
                           {3, 18, 23, 14, 9},
                           {24, 13, 2, 7, 22}};
        assertTrue(ktc.checkValidGrid(grid));
    }

    @Test
    public void sampleInput2() {
        grid = new int[][]{{0, 3, 6},
                           {5, 8, 1},
                           {2, 7, 4}};
        assertFalse(ktc.checkValidGrid(grid));
    }
}
