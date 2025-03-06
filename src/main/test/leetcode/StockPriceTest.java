package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StockPriceTest {
    private final StockPrice stockPrice = new StockPrice();

    @Test
    public void sampleInput1() {
        stockPrice.update(1, 10);
        stockPrice.update(2, 5);
        assertEquals(5, stockPrice.current());
        assertEquals(10, stockPrice.maximum());
        stockPrice.update(1, 3);
        assertEquals(5, stockPrice.maximum());
        stockPrice.update(4, 2);
        assertEquals(2, stockPrice.minimum());
    }
}
