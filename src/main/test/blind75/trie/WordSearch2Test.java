package blind75.trie;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class WordSearch2Test {
    private final WordSearch2 ws = new WordSearch2();
    private char[][] board;
    private String[] words;

    @Test
    public void sampleInput1() {
        board = new char[][]{{'o', 'a', 'a', 'n'},
                             {'e', 't', 'a', 'e'},
                             {'i', 'h', 'k', 'r'},
                             {'i', 'f', 'l', 'v'}};
        words = new String[]{"oath", "pea", "eat", "rain"};

        assertArrayEquals(new String[]{"oath", "eat"}, ws.findWords(board, words).toArray(new String[0]));
    }

    @Test
    public void sampleInput2() {
        board = new char[][]{{'a', 'b'},
                             {'c', 'd'}};
        words = new String[]{"abcb"};

        assertTrue(ws.findWords(board, words).isEmpty());
    }
}
