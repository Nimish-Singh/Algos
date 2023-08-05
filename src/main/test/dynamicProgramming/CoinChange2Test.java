package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinChange2Test {
    private final CoinChange2 c = new CoinChange2();
    private int[] coins;

    @Test
    public void sampleInput1() {
        coins = new int[]{1, 2, 5};
        assertEquals(4, c.change(5, coins));
    }

    @Test
    public void sampleInput2() {
        coins = new int[]{2};
        assertEquals(0, c.change(3, coins));
    }

    @Test
    public void sampleInput3() {
        coins = new int[]{10};
        assertEquals(1, c.change(10, coins));
    }
}
