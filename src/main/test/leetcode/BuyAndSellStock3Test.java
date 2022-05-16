package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuyAndSellStock3Test {
    private BuyAndSellStock3 bss = new BuyAndSellStock3();

    @Test
    public void sampleInput1() {
        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        assertEquals(6, bss.maxProfit(prices));
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

    @Test
    public void sampleInput4() {
        int[] prices = new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
        assertEquals(13, bss.maxProfit(prices));
    }
}
