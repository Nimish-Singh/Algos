package dynamicProgramming;

import java.util.Arrays;

// Similar to BuySellStocksWithCooldown
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
public class BuySellStocksWithFee {
    private int fee;

    public int maxProfit(int[] prices, int fee) {
        this.fee = fee;
        int[][] memo = new int[prices.length][2];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return topDown(prices, 0, true, memo);
    }

    private int topDown(int[] prices, int index, boolean shouldBuy, int[][] memo) {
        if (index >= prices.length)
            return 0;

        if (shouldBuy) {
            if (memo[index][0] != -1) {
                return memo[index][0];
            }
            memo[index][0] = Math.max(-prices[index] + topDown(prices, index + 1, false, memo),
                    topDown(prices, index + 1, true, memo));
            return memo[index][0];
        }

        if (memo[index][1] != -1)
            return memo[index][1];

        memo[index][1] = Math.max(prices[index] - fee + topDown(prices, index + 1, true, memo),
                topDown(prices, index + 1, false, memo));
        return memo[index][1];
    }
}
