package dynamicProgramming;

// https://leetcode.com/problems/longest-common-subsequence/
public class Lcs {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0)
            return 0;

        int rows = text1.length() + 1;
        int columns = text2.length() + 1;
        int[][] memo = new int[rows][columns]; // initial value in all is 0

        /*
        because we want the 0 row/column to start with 0, and let the recurrent relation take care of updating values,
        instead of handling first row/column specially
         */
        for (int row = 1; row < rows; row++) {
            for (int column = 1; column < columns; column++) {
                if (text1.charAt(row - 1) == text2.charAt(column - 1))
                    memo[row][column] = 1 + memo[row - 1][column - 1];
                else
                    memo[row][column] = Math.max(memo[row - 1][column], memo[row][column - 1]);
            }
        }
        return memo[rows - 1][columns - 1];
    }
}
