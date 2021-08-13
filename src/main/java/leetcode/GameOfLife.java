package leetcode;

// https://leetcode.com/problems/game-of-life/
public class GameOfLife {
    private int[][] originalBoard;

    public void gameOfLife(int[][] board) {
        this.originalBoard = new int[board.length][board[0].length];

        for (int row = 0; row < board.length; row++)
            System.arraycopy(board[row], 0, originalBoard[row], 0, board[0].length);

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (originalBoard[row][column] == 0) {
                    board[row][column] = shouldCellLive(0, row, column) ? 1 : 0;
                } else {
                    board[row][column] = shouldCellLive(1, row, column) ? 1 : 0;
                }
            }
        }
    }

    private boolean shouldCellLive(int cellValue, int row, int column) {
        int liveNeighbours = getLiveNeighboursCount(row, column);

        if (cellValue == 0)
            return liveNeighbours == 3;

        return liveNeighbours == 2 || liveNeighbours == 3;
    }

    private int getLiveNeighboursCount(int row, int column) {
        int count = 0;
        for (int rowDiff = -1; rowDiff <= 1; rowDiff++) {
            for (int columnDiff = -1; columnDiff <= 1; columnDiff++) {
                if (rowDiff == 0 && columnDiff == 0)
                    continue;

                int rowToCheck = row + rowDiff;
                int columnToCheck = column + columnDiff;
                if (rowToCheck >= 0 && rowToCheck < originalBoard.length && columnToCheck >= 0 && columnToCheck < originalBoard[0].length)
                    if (originalBoard[rowToCheck][columnToCheck] == 1)
                        count++;
            }
        }
        return count;
    }
}
