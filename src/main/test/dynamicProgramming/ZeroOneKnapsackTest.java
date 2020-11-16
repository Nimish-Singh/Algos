package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ZeroOneKnapsackTest {
    private ZeroOneKnapsack zeroOneKnapsack = new ZeroOneKnapsack();
    private int[] values = new int[]{1, 2, 3};
    private int[] weights = new int[]{4, 5, 1};

    @Test
    public void shouldGiveZeroMaxProfitIfValuesAndWeightsAreNotOfSameSize() {
        weights = new int[]{4, 5, 6, 9};
        assertEquals(0, zeroOneKnapsack.maxValue(values, weights, 7));
    }

    @Test
    public void shouldGiveMaxProfitForValues1() {
        assertEquals(3, zeroOneKnapsack.maxValue(values, weights, 4));
    }

    @Test
    public void shouldGiveMaxProfitForValues2() {
        weights = new int[]{4, 5, 6};
        assertEquals(0, zeroOneKnapsack.maxValue(values, weights, 3));
    }

    @Test
    public void shouldGiveMaxProfitForValues3() {
        values = new int[]{4, 5, 3, 7};
        weights = new int[]{2, 3, 1, 4};
        assertEquals(10, zeroOneKnapsack.maxValue(values, weights, 5));
    }

    @Test
    public void shouldGiveMaxProfitForValues4() {
        values = new int[]{24, 18, 18, 10};
        weights = new int[]{24, 10, 10, 7};
        assertEquals(36, zeroOneKnapsack.maxValue(values, weights, 25));
    }

    @Test
    public void shoufldGiveMaxProfitForValues4() {
        values = new int[]{24, 18, 18, 10, 24, 18, 18, 10, 24, 18, 18, 10, 24, 18, 18, 10, 7, 24, 10, 10, 7, 7, 24, 10, 10, 7};
        weights = new int[]{24, 10, 10, 7, 24, 10, 10, 7, 24, 10, 10, 7, 24, 10, 10, 7, 18, 10, 24, 18, 18, 18, 10, 24, 18, 18};
        assertEquals(396, zeroOneKnapsack.maxValue(values, weights, 2500));
    }
}
