package dynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/integer-break/description/
public class IntegerBreak {
    public int integerBreak(int n) {
//        return recursive(n, true);

        int[][] memo = new int[n][2];
        for (int[] row : memo) Arrays.fill(row, -1);
        return topDown(n, true, memo);
    }

    private int topDown(int n, boolean mustBreak, int[][] memo) {
        if (n == 1)
            return 1;

        int index = mustBreak ? 1 : 0;

        if (memo[n - 1][index] != -1)
            return memo[n - 1][index];

        int answer = mustBreak ? 0 : n;
        for (int i = 1; i < n; i++) {
            answer = Math.max(answer, topDown(i, false, memo) * topDown(n - i, false, memo));
        }

        memo[n - 1][index] = answer;
        return answer;
    }

    private int recursive(int n, boolean mustBreak) {
        if (n == 1) {
            return 1;
        }

        int answer = mustBreak ? 0 : n;

        for (int i = 1; i < n; i++) {
            answer = Math.max(answer, recursive(i, false) * recursive(n - i, false));
        }

        return answer;
    }
}
