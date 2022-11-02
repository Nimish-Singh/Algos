package dynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/coin-change/
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount <= 0)
            return 0;

//        return recursive(amount, coins, coins.length - 1);

        return bottomUpDp(coins, amount);
    }

    private int bottomUpDp(int[] coins, int amount) {
        int[] minCoinsNeeded = new int[amount + 1];
        Arrays.fill(minCoinsNeeded, Integer.MAX_VALUE);
        minCoinsNeeded[0] = 0;

        // https://www.youtube.com/watch?v=Y0ZqKpToTic
        for (int coin : coins) {
            for (int runningAmount = 0; runningAmount <= amount; runningAmount++) {
                if (coin <= runningAmount && minCoinsNeeded[runningAmount - coin] != Integer.MAX_VALUE) {
                    minCoinsNeeded[runningAmount] = Math.min(minCoinsNeeded[runningAmount], 1 + minCoinsNeeded[runningAmount - coin]);
                }
            }
        }
        return minCoinsNeeded[amount] == Integer.MAX_VALUE ? -1 : minCoinsNeeded[amount];
    }

    private int recursive(int amount, int[] coins, int coinIndexToCheck) {
        if (amount == 0)
            return 0;

        if (coinIndexToCheck < 0)
            return -1;

        if (amount < coins[coinIndexToCheck])
            if (coinIndexToCheck == 0)
                return -1;
            else
                return recursive(amount, coins, coinIndexToCheck - 1);


        int whenUsingThisCoin = recursive(amount - coins[coinIndexToCheck], coins, coinIndexToCheck);
        int whenNotUsingThisCoin = recursive(amount, coins, coinIndexToCheck - 1);

        if (whenUsingThisCoin == -1 && whenNotUsingThisCoin == -1)
            return -1;

        if (whenUsingThisCoin == -1)
            return whenNotUsingThisCoin;

        if (whenNotUsingThisCoin == -1)
            return 1 + whenUsingThisCoin;

        return Math.min(1 + whenUsingThisCoin, whenNotUsingThisCoin);
    }
}
