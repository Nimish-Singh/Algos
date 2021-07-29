package backtracking;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WordSearchTest {
    private WordSearch wordSearch = new WordSearch();
    private char[][] board = new char[][]{
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
    };

    @Test
    public void sampleInput1() {
        assertTrue(wordSearch.exist(board, "ABCCED"));
    }

    @Test
    public void sampleInput2() {
        assertTrue(wordSearch.exist(board, "SEE"));
    }

    @Test
    public void sampleInput3() {
        assertFalse(wordSearch.exist(board, "ABCB"));
    }

    @Test
    public void sampleInput4() {
        assertFalse(wordSearch.exist(board, "ESCS"));
    }
}
