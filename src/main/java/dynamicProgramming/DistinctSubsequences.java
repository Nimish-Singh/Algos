package dynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/distinct-subsequences/
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
//        return recursive(s, t, s.length() - 1, t.length() - 1);

        int[][] memo = new int[s.length() + 1][t.length() + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return topDown(s, t, s.length() - 1, t.length() - 1, memo);

//        return bottomUp(s, t);
    }

    private int bottomUp(String s, String t) {
        int[][] memo = new int[s.length() + 1][t.length() + 1];

        for (int row = 0; row < memo.length; row++) {
            memo[row][0] = 1;
        }

        for (int column = 1; column < memo[0].length; column++) {
            memo[0][column] = 0;
        }

        for (int row = 1; row < memo.length; row++) {
            for (int column = 1; column < memo[0].length; column++) {

                if (s.charAt(row - 1) == t.charAt(column - 1)) {
                    memo[row][column] = memo[row - 1][column - 1] + memo[row - 1][column];
                } else {
                    memo[row][column] = memo[row - 1][column];
                }
            }
        }
        return memo[s.length()][t.length()];
    }

    private int topDown(String s, String t, int sIndex, int tIndex, int[][] memo) {
        if (tIndex < 0) {
            return 1;
        }

        if (sIndex < 0) {
            return 0;
        }

        if (memo[sIndex][tIndex] != -1) {
            return memo[sIndex][tIndex];
        }

        if (s.charAt(sIndex) == t.charAt(tIndex)) {
            memo[sIndex][tIndex] = topDown(s, t, sIndex - 1, tIndex - 1, memo) +
                    topDown(s, t, sIndex - 1, tIndex, memo);
            return memo[sIndex][tIndex];
        }

        memo[sIndex][tIndex] = topDown(s, t, sIndex - 1, tIndex, memo);
        return memo[sIndex][tIndex];
    }

    private int recursive(String s, String t, int sIndex, int tIndex) {
        if (tIndex < 0) {
            return 1;
        }

        if (sIndex < 0) {
            return 0;
        }

        if (s.charAt(sIndex) == t.charAt(tIndex)) {
            return recursive(s, t, sIndex - 1, tIndex - 1) + recursive(s, t, sIndex - 1, tIndex);
        }

        return recursive(s, t, sIndex - 1, tIndex);
    }
}
