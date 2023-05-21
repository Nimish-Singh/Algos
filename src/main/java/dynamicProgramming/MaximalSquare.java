package dynamicProgramming;

// https://leetcode.com/problems/maximal-square/
public class MaximalSquare {
    // https://leetcode.com/problems/maximal-square/solutions/600149/python-thinking-process-diagrams-dp-approach/
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] memo = new int[rows + 1][cols + 1];
        int maxSide = 0;

        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= cols; col++) {
                if (matrix[row - 1][col - 1] == '1') {
                    memo[row][col] = Math.min(memo[row - 1][col - 1], Math.min(memo[row - 1][col], memo[row][col - 1])) + 1;
                    maxSide = Math.max(maxSide, memo[row][col]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
