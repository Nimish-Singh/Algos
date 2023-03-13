package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RearrangingFruitsTest {
    private final RearrangingFruits rf = new RearrangingFruits();
    private int[] basket1, basket2;

    @Test
    public void sampleInput1() {
        basket1 = new int[]{4, 2, 2, 2};
        basket2 = new int[]{1, 4, 1, 2};
        assertEquals(1, rf.minCost(basket1, basket2));
    }

    @Test
    public void sampleInput2() {
        basket1 = new int[]{2, 3, 4, 1};
        basket2 = new int[]{3, 2, 5, 1};
        assertEquals(-1, rf.minCost(basket1, basket2));
    }
}
