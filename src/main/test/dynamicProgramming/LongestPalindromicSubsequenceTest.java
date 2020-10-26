package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestPalindromicSubsequenceTest {
    private LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();

    @Test
    public void shouldReturnZeroForEmptyString() {
        assertEquals(0, lps.findLength(""));
    }

    @Test
    public void shouldReturnOneForStringOfLengthOne() {
        assertEquals(1, lps.findLength("h"));
    }

    @Test
    public void shouldReturnLengthWhenEntireStringIsPalindromicWithOddLength() {
        assertEquals(9, lps.findLength("abcdedcba"));
    }

    @Test
    public void shouldReturnLengthWhenEntireStringIsPalindromicWithEvenLength() {
        assertEquals(6, lps.findLength("abccba"));
    }

    @Test
    public void shouldReturnOneWhenNoPalindromicSubsequencePresent() {
        assertEquals(1, lps.findLength("abcdef"));
    }

    @Test
    public void shouldReturnLengthWhenPalindromicSubsequencePresent() {
        assertEquals(5, lps.findLength("iabertba"));
    }
}
