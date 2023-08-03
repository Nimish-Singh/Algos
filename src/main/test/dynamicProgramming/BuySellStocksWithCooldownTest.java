package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuySellStocksWithCooldownTest {
    private final BuySellStocksWithCooldown stocks = new BuySellStocksWithCooldown();
    private int[] prices;

    @Test
    public void sampleInput1() {
        prices = new int[]{1, 2, 3, 0, 2};
        assertEquals(3, stocks.maxProfit(prices));
    }

    @Test
    public void sampleInput2() {
        prices = new int[]{1};
        assertEquals(0, stocks.maxProfit(prices));
    }
}
