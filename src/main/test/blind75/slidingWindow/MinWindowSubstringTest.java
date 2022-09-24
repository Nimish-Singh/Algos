package blind75.slidingWindow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinWindowSubstringTest {
    private final MinWindowSubstring min = new MinWindowSubstring();

    @Test
    public void sampleInput1() {
        assertEquals("BANC", min.minWindow("ADOBECODEBANC", "ABC"));
    }

    @Test
    public void sampleInput2() {
        assertEquals("a", min.minWindow("a", "a"));
    }

    @Test
    public void sampleInput3() {
        assertEquals("", min.minWindow("a", "aa"));
    }

    @Test
    public void sampleInput4() {
        assertEquals("ab", min.minWindow("bdab", "ab"));
    }
}
