package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MiceAndCheeseTest {
    private final MiceAndCheese mc = new MiceAndCheese();
    private int[] reward1;
    private int[] reward2;

    @Test
    public void sampleInput1() {
        reward1 = new int[]{1, 1, 3, 4};
        reward2 = new int[]{4, 4, 1, 1};
        assertEquals(15, mc.miceAndCheese(reward1, reward2, 2));
    }

    @Test
    public void sampleInput2() {
        reward1 = new int[]{1, 1};
        reward2 = new int[]{1, 1};
        assertEquals(2, mc.miceAndCheese(reward1, reward2, 2));
    }

    @Test
    public void sampleInput3() {
        reward1 = new int[]{1, 4, 4, 6, 4};
        reward2 = new int[]{6, 5, 3, 6, 1};
        assertEquals(24, mc.miceAndCheese(reward1, reward2, 1));
    }
}
