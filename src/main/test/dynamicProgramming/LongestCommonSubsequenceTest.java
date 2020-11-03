package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestCommonSubsequenceTest {
    private LongestCommonSubsequence lcs = new LongestCommonSubsequence();

    @Test
    public void shouldReturnLengthLCSLength() {
        assertEquals(3, lcs.findLength("auycibc", "aqcpohyc"));
    }

    @Test
    public void shouldReturnZeroIfLCSNotPresent() {
        assertEquals(0, lcs.findLength("x", "d"));
    }

    @Test
    public void shouldReturnLengthWhenSameStringsPresent() {
        assertEquals(6, lcs.findLength("string", "string"));
    }

    @Test
    public void shouldReturnZeroIfOneStringIsEmpty() {
        assertEquals(0, lcs.findLength("qwer", ""));
    }

    @Test
    public void shouldReturnZeroIfBothStringsAreEmpty() {
        assertEquals(0, lcs.findLength("", ""));
    }
}
