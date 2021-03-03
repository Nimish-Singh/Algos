package slidingWindow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestSubstringWithNoMoreThanKDistinctCharsTest {
    private LongestSubstringWithNoMoreThanKDistinctChars substring = new LongestSubstringWithNoMoreThanKDistinctChars();

    @Test
    public void sampleInput1() {
        assertEquals(4, substring.findLength("araaci", 2));
    }

    @Test
    public void sampleInput2() {
        assertEquals(2, substring.findLength("araaci", 1));
    }

    @Test
    public void sampleInput3() {
        assertEquals(5, substring.findLength("cbbebi", 3));
    }

    @Test
    public void sampleInput4() {
        assertEquals(4, substring.findLength("abcdef", 4));
    }
}
