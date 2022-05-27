package leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WordBreakTest {
    private WordBreak wb = new WordBreak();

    @Test
    public void sampleInput1() {
        assertTrue(wb.wordBreak("leetcode", Arrays.asList("leet", "code")));
    }

    @Test
    public void sampleInput2() {
        assertTrue(wb.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
    }

    @Test
    public void sampleInput3() {
        assertFalse(wb.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }

    @Test
    public void sampleInput4() {
        assertTrue(wb.wordBreak("cars", Arrays.asList("car", "ca", "rs")));
    }

    @Test
    public void sampleInput5() {
        assertFalse(wb.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
    }
}
