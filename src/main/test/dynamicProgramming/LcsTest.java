package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LcsTest {
    private final Lcs lcs = new Lcs();

    @Test
    public void sampleInput1() {
        assertEquals(3, lcs.longestCommonSubsequence("abcde", "ace"));
    }

    @Test
    public void sampleInput2() {
        assertEquals(3, lcs.longestCommonSubsequence("abc", "abc"));
    }

    @Test
    public void sampleInput3() {
        assertEquals(0, lcs.longestCommonSubsequence("abc", "def"));
    }
}
