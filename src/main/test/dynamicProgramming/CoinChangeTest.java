package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinChangeTest {
    private final CoinChange cc = new CoinChange();
    private int[] coins;

    @Test
    public void sampleInput1() {
        coins = new int[]{1, 2, 5};
        assertEquals(3, cc.coinChange(coins, 11));
    }

    @Test
    public void sampleInput2() {
        coins = new int[]{2};
        assertEquals(-1, cc.coinChange(coins, 3));
    }

    @Test
    public void sampleInput3() {
        coins = new int[]{1};
        assertEquals(0, cc.coinChange(coins, 0));
    }

    @Test
    public void sampleInput4() {
        coins = new int[]{186, 419, 83, 408};
        assertEquals(20, cc.coinChange(coins, 6249));
    }
}
