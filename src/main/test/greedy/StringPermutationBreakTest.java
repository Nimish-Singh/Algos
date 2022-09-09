package greedy;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringPermutationBreakTest {
    private final StringPermutationBreak permBreak = new StringPermutationBreak();

    @Test
    public void sampleInput1() {
        assertTrue(permBreak.checkIfCanBreak("abc", "xya"));
    }

    @Test
    public void sampleInput2() {
        assertFalse(permBreak.checkIfCanBreak("abe", "acd"));
    }

    @Test
    public void sampleInput3() {
        assertTrue(permBreak.checkIfCanBreak("leetcode", "interview"));
    }
}
