package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxProductOfWordLengthsTest {
    private final MaxProductOfWordLengths max = new MaxProductOfWordLengths();
    private String[] words;

    @Test
    public void sampleInput1() {
        words = new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        assertEquals(16, max.maxProduct(words));
    }

    @Test
    public void sampleInput2() {
        words = new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        assertEquals(4, max.maxProduct(words));
    }

    @Test
    public void sampleInput3() {
        words = new String[]{"a", "aa", "aaa", "aaaa"};
        assertEquals(0, max.maxProduct(words));
    }
}
