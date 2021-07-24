package leetcode;

// https://leetcode.com/problems/minimum-path-sum/
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0)
            return Integer.MIN_VALUE;

        int[][] sumGrid = new int[grid.length][grid[0].length];
        sumGrid[0][0] = grid[0][0];

        for (int row = 1; row < grid.length; row++)
            sumGrid[row][0] = grid[row][0] + sumGrid[row - 1][0];

        for (int column = 1; column < grid[0].length; column++)
            sumGrid[0][column] = grid[0][column] + sumGrid[0][column - 1];

        for (int row = 1; row < grid.length; row++)
            for (int column = 1; column < grid[0].length; column++)
                sumGrid[row][column] = Math.min(sumGrid[row - 1][column], sumGrid[row][column - 1]) + grid[row][column];

        return sumGrid[grid.length - 1][grid[0].length - 1];
    }
}
