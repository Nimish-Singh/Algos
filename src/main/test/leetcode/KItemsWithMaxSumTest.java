package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KItemsWithMaxSumTest {
    private final KItemsWithMaxSum k = new KItemsWithMaxSum();

    @Test
    public void sampleInput1() {
        assertEquals(2, k.kItemsWithMaximumSum(3, 2, 0, 2));
    }

    @Test
    public void sampleInput2() {
        assertEquals(3, k.kItemsWithMaximumSum(3, 2, 0, 4));
    }
}
