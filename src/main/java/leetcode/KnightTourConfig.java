package leetcode;

// https://leetcode.com/problems/check-knight-tour-configuration/description/
public class KnightTourConfig {
    public boolean checkValidGrid(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return true;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return helper(grid, 0, 0, 0, visited);
    }

    private boolean helper(int[][] grid, int row, int column, int moveNumber, boolean[][] visited) {
        if (row < 0 || column < 0 || row >= grid.length || column >= grid[0].length) {
            return false;
        }

        if (visited[row][column]) {
            return false;
        }

        if (!(grid[row][column] == moveNumber)) {
            return false;
        }

        visited[row][column] = true;
        if (moveNumber == grid.length * grid[0].length - 1) {
            return true;
        }

        return helper(grid, row - 2, column - 1, moveNumber + 1, visited) ||
            helper(grid, row - 1, column - 2, moveNumber + 1, visited) ||
            helper(grid, row + 1, column - 2, moveNumber + 1, visited) ||
            helper(grid, row + 2, column - 1, moveNumber + 1, visited) ||
            helper(grid, row - 2, column + 1, moveNumber + 1, visited) ||
            helper(grid, row - 1, column + 2, moveNumber + 1, visited) ||
            helper(grid, row + 1, column + 2, moveNumber + 1, visited) ||
            helper(grid, row + 2, column + 1, moveNumber + 1, visited);
    }
}
