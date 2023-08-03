package dynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
public class BuySellStocksWithCooldown {
    public int maxProfit(int[] prices) {
//        return recursive(prices, 0, true);

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

        memo[index][1] = Math.max(prices[index] + topDown(prices, index + 2, true, memo),
                topDown(prices, index + 1, false, memo));
        return memo[index][1];
    }

    private int recursive(int[] prices, int index, boolean shouldBuy) {
        if (index >= prices.length)
            return 0;

        if (shouldBuy) {
            return Math.max(-prices[index] + recursive(prices, index + 1, false),
                    recursive(prices, index + 1, true));
        }

        return Math.max(prices[index] + recursive(prices, index + 2, true),
                recursive(prices, index + 1, false));
    }
}
