package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BytelandGoldCoinExchangeTest {
    private BytelandGoldCoinExchange bytelandGoldCoinExchange = new BytelandGoldCoinExchange();

    @Test
    public void shouldReturnZeroForZeroCoins() {
        assertEquals(0, bytelandGoldCoinExchange.maxExchangeValue(0));
    }

    @Test
    public void shouldReturnOneForOneCoin() {
        assertEquals(1, bytelandGoldCoinExchange.maxExchangeValue(1));
    }

    @Test
    public void shouldReturnTwoForTwoCoins() {
        assertEquals(2, bytelandGoldCoinExchange.maxExchangeValue(2));
    }

    @Test
    public void shouldReturnThirteenForTwelveCoins() {
        assertEquals(13, bytelandGoldCoinExchange.maxExchangeValue(12));
    }
}
