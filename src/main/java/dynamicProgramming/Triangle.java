package dynamicProgramming;

import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/triangle
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
//        return recursive(triangle, 0, 0);
        int[][] memo = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        for (int[] row : memo)
            Arrays.fill(row, Integer.MAX_VALUE);
//        return topDownDp(triangle, 0, 0, memo);
        return bottomUpDp(triangle);
    }

    // https://leetcode.com/problems/triangle/solutions/2144980/from-memoization-to-dp-java-explanation/
    private int bottomUpDp(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int maxCols = triangle.get(triangle.size() - 1).size();
        int[][] minSums = new int[rows][maxCols];

        for (int[] row : minSums)
            Arrays.fill(row, Integer.MAX_VALUE);

        for (int col = 0; col < maxCols; col++)
            minSums[rows - 1][col] = triangle.get(rows - 1).get(col);

        for (int row = rows - 2; row >= 0; row--) {
            for (int col = 0; col < maxCols; col++) {
                if (col < triangle.get(row).size()) {
                    minSums[row][col] = triangle.get(row).get(col) + Math.min(minSums[row + 1][col], minSums[row + 1][col + 1]);
                }
            }
        }

        return minSums[0][0];
    }

    private int topDownDp(List<List<Integer>> triangle, int row, int col, int[][] memo) {
        if (row >= triangle.size() || col >= triangle.get(row).size())
            return 0;

        if (memo[row][col] != Integer.MAX_VALUE)
            return memo[row][col];
        int minSum = triangle.get(row).get(col) + Math.min(topDownDp(triangle, row + 1, col, memo),
            topDownDp(triangle, row + 1, col + 1, memo));
        memo[row][col] = minSum;
        return memo[row][col];
    }

    private int recursive(List<List<Integer>> triangle, int row, int col) {
        if (row >= triangle.size() || col >= triangle.get(row).size())
            return 0;

        return triangle.get(row).get(col) + Math.min(recursive(triangle, row + 1, col),
            recursive(triangle, row + 1, col + 1));
    }
}
