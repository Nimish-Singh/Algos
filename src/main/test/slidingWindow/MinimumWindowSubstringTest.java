package slidingWindow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumWindowSubstringTest {
    private final MinimumWindowSubstring min = new MinimumWindowSubstring();

    @Test
    public void sampleInput1() {
        assertEquals("BANC", min.minWindow("ADOBECODEBANC", "ABC"));
    }

    @Test
    public void sampleInput2() {
        assertEquals("", min.minWindow("a", "aa"));
    }

    @Test
    public void sampleInput3() {
        assertEquals("a", min.minWindow("a", "a"));
    }
}
