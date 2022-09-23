package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestRepeatingCharacterReplacementTest {
    private final LongestRepeatingCharacterReplacement replacement = new LongestRepeatingCharacterReplacement();

    @Test
    public void sampleInput1() {
        assertEquals(4, replacement.characterReplacement("ABAB", 2));
    }

    @Test
    public void sampleInput2() {
        assertEquals(4, replacement.characterReplacement("AABABBA", 1));
    }
}
