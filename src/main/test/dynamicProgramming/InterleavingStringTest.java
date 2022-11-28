package dynamicProgramming;

import dynamicProgramming.InterleavingString;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InterleavingStringTest {
    private final InterleavingString i = new InterleavingString();

    @Test
    public void sampleInput1() {
        assertTrue(i.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    @Test
    public void sampleInput2() {
        assertFalse(i.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

    @Test
    public void sampleInput3() {
        assertTrue(i.isInterleave("", "", ""));
    }
}
