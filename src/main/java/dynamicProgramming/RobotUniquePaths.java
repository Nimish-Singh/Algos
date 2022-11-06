package dynamicProgramming;

// https://leetcode.com/problems/unique-paths/
public class RobotUniquePaths {
    private int paths;

    /*
    Mathematically, this problem is (rows + columns)C(rows) or (rows + columns)C(columns)
    Explanation- https://betterexplained.com/articles/navigate-a-grid-using-combinations-and-permutations/
     */
    public int uniquePaths(int rows, int columns) {
        if (rows == 0 || columns == 0)
            return 0;

        int[][] memo = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            memo[row][0] = 1;
        }

        for (int column = 0; column < columns; column++) {
            memo[0][column] = 1;
        }

        for (int row = 1; row < rows; row++) {
            for (int column = 1; column < columns; column++) {
                memo[row][column] = memo[row - 1][column] + memo[row][column - 1];
            }
        }

        return memo[rows - 1][columns - 1];
        /*
        paths = 0;
        recursive(rows, columns, 0, 0);
        return paths;
         */
    }

    private void recursive(int rows, int columns, int currentRow, int currentColumn) {
        if (currentRow == rows - 1 && currentColumn == columns - 1)
            paths++;

        if (currentRow < rows - 1)
            recursive(rows, columns, currentRow + 1, currentColumn);
        if (currentColumn < columns - 1)
            recursive(rows, columns, currentRow, currentColumn + 1);
    }
}
