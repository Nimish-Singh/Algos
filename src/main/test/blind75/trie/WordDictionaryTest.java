package blind75.trie;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WordDictionaryTest {
    private WordDictionary wd;

    @Test
    public void sampleInput1() {
        wd = new WordDictionary();

        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");

        assertFalse(wd.search("pad"));
        assertTrue(wd.search("bad"));
        assertTrue(wd.search(".ad"));
        assertTrue(wd.search("b.."));
    }
}
