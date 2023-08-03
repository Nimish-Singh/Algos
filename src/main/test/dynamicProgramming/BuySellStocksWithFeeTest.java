package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuySellStocksWithFeeTest {
    private final BuySellStocksWithFee stocks = new BuySellStocksWithFee();
    private int[] prices;

    @Test
    public void sampleInput1() {
        prices = new int[]{1, 3, 2, 8, 4, 9};
        assertEquals(8, stocks.maxProfit(prices, 2));
    }

    @Test
    public void sampleInput2() {
        prices = new int[]{1, 3, 7, 5, 10, 3};
        assertEquals(6, stocks.maxProfit(prices, 3));
    }
}
