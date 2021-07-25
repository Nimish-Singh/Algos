package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestConsecutiveSequenceTest {
    private LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();

    @Test
    public void sampleInput1() {
        assertEquals(4, lcs.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    @Test
    public void sampleInput2() {
        assertEquals(9, lcs.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }
}
