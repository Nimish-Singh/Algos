package blind75.trie;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TrieTest {
    private Trie trie;

    @Test
    public void sampleInput1() {
        trie = new Trie();

        trie.insert("apple");
        assertTrue(trie.search("apple"));
        assertFalse(trie.search("app"));

        trie.insert("app");
        assertTrue(trie.startsWith("app"));
    }
}
