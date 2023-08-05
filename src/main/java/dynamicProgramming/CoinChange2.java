package dynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/coin-change-ii/
public class CoinChange2 {
    public int change(int amount, int[] coins) {
//        return recursive(amount, coins, 0);

        int[][] memo = new int[coins.length][amount];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        return topDown(amount, coins, 0, memo);
    }

    private int topDown(int amount, int[] coins, int index, int[][] memo) {
        if (amount == 0)
            return 1;

        if (amount < 0 || index >= coins.length)
            return 0;

        if (memo[index][amount - 1] != -1)
            return memo[index][amount - 1];

        if (amount < coins[index]) {
            memo[index][amount - 1] = topDown(amount, coins, index + 1, memo);
            return memo[index][amount - 1];
        }

        memo[index][amount - 1] = topDown(amount - coins[index], coins, index, memo) + topDown(amount, coins, index + 1, memo);
        return memo[index][amount - 1];
    }

    private int recursive(int amount, int[] coins, int index) {
        if (amount == 0)
            return 1;

        if (amount < 0 || index >= coins.length)
            return 0;

        if (amount < coins[index]) {
            return recursive(amount, coins, index + 1);
        }

        return recursive(amount - coins[index], coins, index) + recursive(amount, coins, index + 1);
    }
}
