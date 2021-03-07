package slidingWindow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestSubstringWithSameLettersAfterKReplacementTest {
    private LongestSubstringWithSameLettersAfterKReplacement substring = new LongestSubstringWithSameLettersAfterKReplacement();

    @Test
    public void sampleinput1() {
        assertEquals(5, substring.findLength("aabccbb", 2));
    }

    @Test
    public void sampleinput2() {
        assertEquals(4, substring.findLength("abbcb", 1));
    }

    @Test
    public void sampleinput3() {
        assertEquals(3, substring.findLength("abccde", 1));
    }
}
