package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestBalancedBinarySubstringTest {
    private final LongestBalancedBinarySubstring l = new LongestBalancedBinarySubstring();

    @Test
    public void sampleInput1() {
        assertEquals(0, l.findTheLongestBalancedSubstring(""));
    }

    @Test
    public void sampleInput2() {
        assertEquals(6, l.findTheLongestBalancedSubstring("01000111"));
    }

    @Test
    public void sampleInput3() {
        assertEquals(4, l.findTheLongestBalancedSubstring("00111"));
    }

    @Test
    public void sampleInput4() {
        assertEquals(0, l.findTheLongestBalancedSubstring("111"));
    }
}
