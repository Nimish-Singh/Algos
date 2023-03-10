package dynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/number-of-ways-to-earn-points/description/
public class WaysToEarnPoints {
    public int waysToReachTarget(int target, int[][] types) {
        int[][] memo = new int[target + 1][types.length + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return helper(0, target, types, memo);
    }

    private int helper(int index, int target, int[][] types, int[][] memo) {
        if (target == 0)
            return 1;

        if (index >= types.length || target < 0)
            return 0;

        if (memo[target][index] != -1)
            return memo[target][index];

        int ways = 0;
        for (int j = 0; j <= types[index][0]; j++)
            ways = (ways + helper(index + 1, target - j * types[index][1], types, memo)) % 1000000007;
        memo[target][index] = ways;

        return ways;
    }
}
