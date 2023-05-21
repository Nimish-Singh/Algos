package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://leetcode.com/problems/minimum-falling-path-sum/
public class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
//        List<Integer> mins = new ArrayList<>();
//        for (int col = 0; col < matrix[0].length; col++) {
//            mins.add(recursive(matrix, 0, col));
//        }
//        return mins.stream().min(Comparator.comparingInt(a -> a)).get();

//        List<Integer> mins = new ArrayList<>();
//        int[][] memo = new int[matrix.length][matrix[0].length];
//        for (int[] row : memo)
//            Arrays.fill(row, Integer.MAX_VALUE);
//        for (int col = 0; col < matrix[0].length; col++) {
//            mins.add(topDownDp(matrix, 0, col, memo));
//        }
//        return mins.stream().min(Comparator.comparingInt(a -> a)).get();

                return bottomUpDp(matrix);
    }

    private int topDownDp(int[][] matrix, int row, int col, int[][] memo) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length)
            return Integer.MAX_VALUE;

        if (memo[row][col] != Integer.MAX_VALUE)
            return memo[row][col];

        int minFromNextRow = Math.min(topDownDp(matrix, row + 1, col - 1, memo),
            Math.min(topDownDp(matrix, row + 1, col, memo), topDownDp(matrix, row + 1, col + 1, memo)));
        memo[row][col] = minFromNextRow == Integer.MAX_VALUE ? matrix[row][col] : matrix[row][col] + minFromNextRow;
        return memo[row][col];
    }

    private int recursive(int[][] matrix, int row, int col) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length)
            return Integer.MAX_VALUE;

        int minFromNextRow = Math.min(recursive(matrix, row + 1, col - 1),
            Math.min(recursive(matrix, row + 1, col), recursive(matrix, row + 1, col + 1)));
        return minFromNextRow == Integer.MAX_VALUE ? matrix[row][col] : matrix[row][col] + minFromNextRow;
    }

    // https://leetcode.com/problems/minimum-falling-path-sum/solutions/186689/java-dp-solution-with-graph-illustrated-explanations/
    private int bottomUpDp(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] minSum = new int[rows][cols + 2];

        for (int col = 1; col <= cols; col++)
            minSum[rows - 1][col] = matrix[rows - 1][col - 1];

        for (int row = 0; row < rows; row++) {
            minSum[row][0] = Integer.MAX_VALUE;
            minSum[row][cols + 1] = Integer.MAX_VALUE;
        }

        for (int row = rows - 2; row >= 0; row--) {
            for (int col = 1; col <= cols; col++) {
                minSum[row][col] = Math.min(minSum[row + 1][col - 1], Math.min(minSum[row + 1][col], minSum[row + 1][col + 1])) + matrix[row][col - 1];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int col = 0; col <= cols; col++)
            min = Math.min(min, minSum[0][col]);

        return min;
    }
}
