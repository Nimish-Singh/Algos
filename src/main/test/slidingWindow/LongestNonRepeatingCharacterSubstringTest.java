package slidingWindow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestNonRepeatingCharacterSubstringTest {
    private LongestNonRepeatingCharacterSubstring substring = new LongestNonRepeatingCharacterSubstring();

    @Test
    public void sampleInput1() {
        assertEquals(3, substring.findLength("aabccbb"));
    }

    @Test
    public void sampleInput2() {
        assertEquals(2, substring.findLength("abbbb"));
    }

    @Test
    public void sampleInput3() {
        assertEquals(3, substring.findLength("abccde"));
    }
}
