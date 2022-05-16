package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuySellStock1Test {
    private BuySellStock1 bss = new BuySellStock1();

    @Test
    public void sampleInput1() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        assertEquals(5, bss.maxProfit(prices));
    }

    @Test
    public void sampleInput2() {
        int[] prices = new int[]{7, 6, 4, 3, 1};
        assertEquals(0, bss.maxProfit(prices));
    }

    @Test
    public void sampleInput3() {
        assertEquals(0, bss.maxProfit(null));
    }
}
