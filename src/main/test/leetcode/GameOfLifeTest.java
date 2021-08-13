package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class GameOfLifeTest {
    private GameOfLife game = new GameOfLife();
    private int[][] board;

    @Test
    public void sampleInput1() {
        board = new int[][]{{0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}};
        game.gameOfLife(board);
        assertArrayEquals(new int[]{0, 0, 0}, board[0]);
        assertArrayEquals(new int[]{1, 0, 1}, board[1]);
        assertArrayEquals(new int[]{0, 1, 1}, board[2]);
        assertArrayEquals(new int[]{0, 1, 0}, board[3]);
    }

    @Test
    public void sampleInput2() {
        board = new int[][]{{1, 1},
                {1, 0}};
        game.gameOfLife(board);
        assertArrayEquals(new int[]{1, 1}, board[0]);
        assertArrayEquals(new int[]{1, 1}, board[1]);
    }
}
