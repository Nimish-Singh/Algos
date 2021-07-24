package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinPathSumTest {
    private MinPathSum sum = new MinPathSum();
    private int[][] grid;

    @Test
    public void sampleInput1() {
        grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        assertEquals(7, sum.minPathSum(grid));
    }

    @Test
    public void sampleInput2() {
        grid = new int[][]{};
        assertEquals(Integer.MIN_VALUE, sum.minPathSum(grid));
    }

    @Test
    public void sampleInput3() {
        grid = new int[][]{{1, 2, 3}, {4, 5, 6}};
        assertEquals(12, sum.minPathSum(grid));
    }
}
