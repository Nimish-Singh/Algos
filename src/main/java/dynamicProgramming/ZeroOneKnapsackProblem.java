package dynamicProgramming;

import java.util.Arrays;

public class ZeroOneKnapsackProblem {
    public int maxProfit(int[] profits, int[] weights, int capacity) {
//        return recursive(profits, weights, capacity, 0);

        int[][] memo = new int[weights.length][capacity + 1];
        for (int[] row : memo)
            Arrays.fill(row, Integer.MIN_VALUE);
        return topDown(memo, profits, weights, capacity, 0);

//        return bottomUp(profits, weights, capacity);
    }

    private int recursive(int[] profits, int[] weights, int capacity, int index) {
        if (capacity <= 0 || index >= profits.length)
            return 0;
        int profitWhenTakingThisItem = 0;
        if (weights[index] <= capacity)
            profitWhenTakingThisItem = profits[index] + recursive(profits, weights, capacity - weights[index], index + 1);
        int profitWhenSkippingThisItem = recursive(profits, weights, capacity, index + 1);
        return Math.max(profitWhenTakingThisItem, profitWhenSkippingThisItem);
    }

    private int topDown(int[][] memo, int[] profits, int[] weights, int capacity, int index) {
        if (capacity <= 0 || index >= profits.length)
            return 0;

        if (memo[index][capacity] != Integer.MIN_VALUE)
            return memo[index][capacity];

        int profitWhenTakingThisItem = 0;
        if (weights[index] <= capacity)
            profitWhenTakingThisItem = profits[index] + topDown(memo, profits, weights, capacity - weights[index], index + 1);
        int profitWhenSkippingThisItem = topDown(memo, profits, weights, capacity, index + 1);
        memo[index][capacity] = Math.max(profitWhenTakingThisItem, profitWhenSkippingThisItem);
        return memo[index][capacity];
    }

    private int bottomUp(int[] profits, int[] weights, int capacity) {
        if (capacity <= 0 || profits.length == 0)
            return 0;

        int[][] memo = new int[weights.length][capacity + 1];

        for (int index = 0; index < memo.length; index++)
            memo[index][0] = 0;

        for (int weight = 0; weight <= capacity; weight++)
            if (weights[0] <= weight)
                memo[0][weight] = profits[0];
            else
                memo[0][weight] = 0;

        for (int index = 1; index < memo.length; index++) {
            for (int weight = 1; weight <= capacity; weight++) {
                int profitWhenTakingThisItem = 0;
                if (weights[index] <= weight)
                    profitWhenTakingThisItem = profits[index] + memo[index - 1][weight - weights[index]];
                int profitWhenSkippingThisItem = memo[index - 1][weight];
                memo[index][weight] = Math.max(profitWhenTakingThisItem, profitWhenSkippingThisItem);
            }
        }
        return memo[weights.length - 1][capacity];
    }
}
