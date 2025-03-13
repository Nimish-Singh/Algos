package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubstringsContainingAllCharsTest {
    private final SubstringsContainingAllChars counter = new SubstringsContainingAllChars();

    @Test
    public void sampleInput1() {
        assertEquals(10, counter.numberOfSubstrings("abcabc"));
    }

    @Test
    public void sampleInput2() {
        assertEquals(3, counter.numberOfSubstrings("aaacb"));
    }

    @Test
    public void sampleInput3() {
        assertEquals(1, counter.numberOfSubstrings("acb"));
    }

    @Test
    public void sampleInput4() {
        assertEquals(0, counter.numberOfSubstrings("ababababa"));
    }
}
