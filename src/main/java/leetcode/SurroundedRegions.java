package leetcode;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/surrounded-regions/
public class SurroundedRegions {
    public void solve(char[][] board) {
        Queue<Point> safeO = new LinkedList<>();

        int rows = board.length;
        int columns = board[0].length;

        for (int row = 0; row < rows; row++) {
            if (board[row][0] == 'O')
                safeO.offer(new Point(row, 0));
            if (board[row][columns - 1] == 'O')
                safeO.offer(new Point(row, columns - 1));
        }

        for (int column = 0; column < columns; column++) {
            if (board[0][column] == 'O')
                safeO.offer(new Point(0, column));
            if (board[rows - 1][column] == 'O')
                safeO.offer(new Point(rows - 1, column));
        }

        while (!safeO.isEmpty()) {
            Point zero = safeO.poll();
            int x = zero.x;
            int y = zero.y;
            board[x][y] = '+';

            if (x > 0 && board[x - 1][y] == 'O')
                safeO.offer(new Point(x - 1, y));

            if (y > 0 && board[x][y - 1] == 'O')
                safeO.offer(new Point(x, y - 1));

            if (x < rows - 1 && board[x + 1][y] == 'O')
                safeO.offer(new Point(x + 1, y));

            if (y < columns - 1 && board[x][y + 1] == 'O')
                safeO.offer(new Point(x, y + 1));
        }

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (board[row][column] == 'O')
                    board[row][column] = 'X';
                else if (board[row][column] == '+')
                    board[row][column] = 'O';
            }
        }
    }
}
