package dynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings
public class MinAsciiDeleteSum {
    public int minimumDeleteSum(String s1, String s2) {
        // We can also start with 0,0 index
//        return recursive(s1, s2, s1.length() - 1, s2.length() - 1);

//        int[][] memo = new int[s1.length() + 1][s2.length() + 1];
//        for (int[] row : memo)
//            Arrays.fill(row, -1);
//        return topDown(s1, s2, s1.length(), s2.length(), memo);

        return bottomUp(s1, s2);
    }

    // https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/editorial
    private int bottomUp(String s1, String s2) {
        int[][] memo = new int[s1.length() + 1][s2.length() + 1];

        memo[0][0] = 0;

        for (int row = 1; row < memo.length; row++)
            memo[row][0] = memo[row - 1][0] + s1.charAt(row - 1);

        for (int column = 1; column < memo[0].length; column++)
            memo[0][column] = memo[0][column - 1] + s2.charAt(column - 1);

        for (int row = 1; row < memo.length; row++) {
            for (int column = 1; column < memo[0].length; column++) {
                if (s1.charAt(row - 1) == s2.charAt(column - 1))
                    memo[row][column] = memo[row - 1][column - 1];
                else
                    memo[row][column] = Math.min(
                        s1.charAt(row - 1) + memo[row - 1][column],
                        s2.charAt(column - 1) + memo[row][column - 1]
                    );
            }
        }
        return memo[s1.length()][s2.length()];
    }

    private int topDown(String s1, String s2, int index1, int index2, int[][] memo) {
        if (index1 == 0) {
            int cost = 0;
            for (int pointer = 0; pointer < index2; pointer++)
                cost += s2.charAt(pointer);
            memo[index1][index2] = cost;
            return memo[index1][index2];
        }

        if (index2 == 0) {
            int cost = 0;
            for (int pointer = 0; pointer < index1; pointer++)
                cost += s1.charAt(pointer);
            memo[index1][index2] = cost;
            return memo[index1][index2];
        }

        if (memo[index1][index2] != -1)
            return memo[index1][index2];

        if (s1.charAt(index1 - 1) == s2.charAt(index2 - 1)) {
            memo[index1][index2] = topDown(s1, s2, index1 - 1, index2 - 1, memo);
            return memo[index1][index2];
        }

        memo[index1][index2] = Math.min(
            (int) s1.charAt(index1 - 1) + topDown(s1, s2, index1 - 1, index2, memo),
            Math.min(
                (int) s2.charAt(index2 - 1) + topDown(s1, s2, index1, index2 - 1, memo),
                (int) s1.charAt(index1 - 1) + (int) s2.charAt(index2 - 1) + topDown(s1, s2, index1 - 1, index2 - 1, memo)
            )
        );
        return memo[index1][index2];
    }

    private int recursive(String s1, String s2, int index1, int index2) {
        if (index1 < 0) {
            int cost = 0;
            for (int pointer = 0; pointer <= index2; pointer++)
                cost += s2.charAt(pointer);
            return cost;
        }

        if (index2 < 0) {
            int cost = 0;
            for (int pointer = 0; pointer <= index1; pointer++)
                cost += s1.charAt(pointer);
            return cost;
        }

        if (s1.charAt(index1) == s2.charAt(index2))
            return recursive(s1, s2, index1 - 1, index2 - 1);

        return Math.min(
            (int) s1.charAt(index1) + recursive(s1, s2, index1 - 1, index2),
            Math.min(
                (int) s2.charAt(index2) + recursive(s1, s2, index1, index2 - 1),
                (int) s1.charAt(index1) + (int) s2.charAt(index2) + recursive(s1, s2, index1 - 1, index2 - 1)
            )
        );
    }
}
