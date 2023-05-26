package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestPalindromicSubstringTest {
    private final LongestPalindromicSubstring lps = new LongestPalindromicSubstring();

    @Test
    public void sampleInput1() {
        assertEquals("bab", lps.longestPalindrome("babad"));
    }

    @Test
    public void sampleInput2() {
        assertEquals("bb", lps.longestPalindrome("cbbd"));
    }

    @Test
    public void sampleInput3() {
        assertEquals("a", lps.longestPalindrome("abcd"));
    }
}
