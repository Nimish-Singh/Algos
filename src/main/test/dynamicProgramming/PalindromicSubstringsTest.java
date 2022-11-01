package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PalindromicSubstringsTest {
    private final PalindromicSubstrings pal = new PalindromicSubstrings();

    @Test
    public void sampleInput1() {
        assertEquals(3, pal.countSubstrings("abc"));
    }

    @Test
    public void sampleInput2() {
        assertEquals(6, pal.countSubstrings("aaa"));
    }
}
