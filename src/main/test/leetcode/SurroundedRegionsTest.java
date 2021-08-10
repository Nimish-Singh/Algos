package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SurroundedRegionsTest {
    private SurroundedRegions sr = new SurroundedRegions();
    private char[][] board;

    @Test
    public void sampleInput1() {
        board = new char[][]{{'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};

        sr.solve(board);

        assertArrayEquals(new char[]{'X', 'X', 'X', 'X'}, board[0]);
        assertArrayEquals(new char[]{'X', 'X', 'X', 'X'}, board[1]);
        assertArrayEquals(new char[]{'X', 'X', 'X', 'X'}, board[2]);
        assertArrayEquals(new char[]{'X', 'O', 'X', 'X'}, board[3]);
    }

    @Test
    public void sampleInput2() {
        board = new char[][]{{'X'}};

        sr.solve(board);

        assertArrayEquals(new char[]{'X'}, board[0]);
    }

    @Test
    public void sampleInput3() {
        board = new char[][]{{'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'X', 'X'}};

        sr.solve(board);

        assertArrayEquals(new char[]{'X', 'X', 'X', 'X'}, board[0]);
        assertArrayEquals(new char[]{'X', 'O', 'O', 'X'}, board[1]);
        assertArrayEquals(new char[]{'X', 'O', 'X', 'X'}, board[2]);
        assertArrayEquals(new char[]{'X', 'O', 'X', 'X'}, board[3]);
    }

    @Test
    public void sampleInput4() {
        board = new char[][]{{'X', 'X', 'X', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'X', 'X'}};

        sr.solve(board);

        assertArrayEquals(new char[]{'X', 'X', 'X', 'X'}, board[0]);
        assertArrayEquals(new char[]{'X', 'X', 'X', 'X'}, board[1]);
        assertArrayEquals(new char[]{'X', 'O', 'X', 'X'}, board[2]);
        assertArrayEquals(new char[]{'X', 'O', 'X', 'X'}, board[3]);
    }
}
