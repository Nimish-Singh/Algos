package dynamicProgramming;

// https://leetcode.com/problems/unique-paths
public class UniquePaths {
    public int uniquePaths(int m, int n) {
//        return recursive(m, n, 1, 1);

//        int[][] memo = new int[m + 1][n + 1];
//        return topDownDp(m, n, 1, 1, memo);

        return bottomUpDp(m, n);
    }

    private int bottomUpDp(int m, int n) {
        int[][] memo = new int[m][n];
        memo[0][0] = 1;
        for (int index = 1; index < m; index++) {
            memo[index][0] = 1;
        }
        for (int index = 1; index < n; index++) {
            memo[0][index] = 1;
        }

        for (int row = 1; row < m; row++) {
            for (int column = 1; column < n; column++)
                memo[row][column] = memo[row - 1][column] + memo[row][column - 1];
        }
        return memo[m - 1][n - 1];
    }

    private int topDownDp(int m, int n, int row, int column, int[][] memo) {
        if (row > m || column > n)
            return 0;

        if (row == m && column == n) {
            return 1;
        }

        if (memo[row][column] != 0) {
            return memo[row][column];
        }

        memo[row][column] = topDownDp(m, n, row + 1, column, memo) + topDownDp(m, n, row, column + 1, memo);
        return memo[row][column];
    }

    private int recursive(int m, int n, int row, int column) {
        if (row > m || column > n)
            return 0;

        if (row == m && column == n) {
            return 1;
        }

        return recursive(m, n, row + 1, column) + recursive(m, n, row, column + 1);
    }
}
