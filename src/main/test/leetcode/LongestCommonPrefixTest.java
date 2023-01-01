package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestCommonPrefixTest {
    private final LongestCommonPrefix longest = new LongestCommonPrefix();

    @Test
    public void sampleInput1() {
        assertEquals("fl", longest.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    @Test
    public void sampleInput2() {
        assertEquals("", longest.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}
