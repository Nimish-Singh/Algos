package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MinCostWalkTest {
    private final MinCostWalk minCostWalk = new MinCostWalk();
    private int[][] edges;
    private int[][] queries;

    @Test
    public void sampleInput1() {
        edges = new int[][]{{0, 1, 7}, {1, 3, 7}, {1, 2, 1}};
        queries = new int[][]{{0, 3}, {3, 4}};

        assertArrayEquals(new int[]{1, -1}, minCostWalk.minimumCost(5, edges, queries));
    }

    @Test
    public void sampleInput2() {
        edges = new int[][]{{0, 2, 7}, {0, 1, 1}, {1, 2, 6}, {1, 2, 1}};
        queries = new int[][]{{1, 2}};

        assertArrayEquals(new int[]{0}, minCostWalk.minimumCost(3, edges, queries));
    }
}
