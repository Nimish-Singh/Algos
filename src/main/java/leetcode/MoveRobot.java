package leetcode;

// https://leetcode.com/problems/unique-paths-ii/
public class MoveRobot {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int numberOfRows = obstacleGrid.length;
        int numberOfColumns = obstacleGrid[0].length;

        int[][] pathCount = new int[numberOfRows][numberOfColumns];
        pathCount[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for (int row = 1; row < numberOfRows; row++)
            pathCount[row][0] = obstacleGrid[row][0] == 1 ? 0 : pathCount[row - 1][0];

        for (int column = 1; column < numberOfColumns; column++)
            pathCount[0][column] = obstacleGrid[0][column] == 1 ? 0 : pathCount[0][column - 1];

        for (int row = 1; row < numberOfRows; row++) {
            for (int column = 1; column < numberOfColumns; column++) {
                pathCount[row][column] = obstacleGrid[row][column] == 1 ? 0 : pathCount[row - 1][column] + pathCount[row][column - 1];
            }
        }

        return pathCount[numberOfRows - 1][numberOfColumns - 1];
    }
}
