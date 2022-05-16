package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuyAndSellStock2Test {
    private BuyAndSellStock2 bss = new BuyAndSellStock2();

    @Test
    public void sampleInput1() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        assertEquals(7, bss.maxProfit(prices));
    }

    @Test
    public void sampleInput2() {
        int[] prices = new int[]{1, 2, 3, 4, 5};
        assertEquals(4, bss.maxProfit(prices));
    }

    @Test
    public void sampleInput3() {
        int[] prices = new int[]{7, 6, 4, 3, 1};
        assertEquals(0, bss.maxProfit(prices));
    }
}
