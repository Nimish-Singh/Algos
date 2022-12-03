package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestSubstringKRepCharsTest {
    private final LongestSubstringKRepChars l = new LongestSubstringKRepChars();

    @Test
    public void sampleInput1() {
        assertEquals(3, l.longestSubstring("aaabb", 3));
    }

    @Test
    public void sampleInput2() {
        assertEquals(5, l.longestSubstring("ababbc", 2));
    }
}
