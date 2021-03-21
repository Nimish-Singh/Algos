package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ZeroOneKnapsackProblemTest {
    private ZeroOneKnapsackProblem knapsack = new ZeroOneKnapsackProblem();

    @Test
    public void sampleInput1() {
        int[] values = new int[]{4, 5, 3, 7};
        int[] weights = new int[]{2, 3, 1, 4};
        assertEquals(10, knapsack.maxProfit(values, weights, 5));
    }
}
