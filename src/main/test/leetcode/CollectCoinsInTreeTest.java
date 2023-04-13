package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CollectCoinsInTreeTest {
    private final CollectCoinsInTree cTree = new CollectCoinsInTree();
    private int[] coins;
    private int[][] edges;

    @Test
    public void sampleInput1() {
        coins = new int[]{1, 0, 0, 0, 0, 1};
        edges = new int[][]{{0, 1},
                            {1, 2},
                            {2, 3},
                            {3, 4},
                            {4, 5}};
        assertEquals(2, cTree.collectTheCoins(coins, edges));
    }

    @Test
    public void sampleInput2() {
        coins = new int[]{0, 0, 0, 1, 1, 0, 0, 1};
        edges = new int[][]{{0, 1},
                            {0, 2},
                            {1, 3},
                            {1, 4},
                            {2, 5},
                            {5, 6},
                            {5, 7}};
        assertEquals(2, cTree.collectTheCoins(coins, edges));
    }

    @Test
    public void sampleInput3() {
        coins = new int[]{0, 0};
        edges = new int[][]{{0, 1}};
        assertEquals(0, cTree.collectTheCoins(coins, edges));
    }
}
