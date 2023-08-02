package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestArithmeticSubsequenceAnyDiffTest {
    private final LongestArithmeticSubsequenceAnyDiff l = new LongestArithmeticSubsequenceAnyDiff();
    private int[] nums;

    @Test
    public void sampleInput1() {
        nums = new int[]{3, 6, 9, 12};
        assertEquals(4, l.longestArithSeqLength(nums));
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{9, 4, 7, 2, 10};
        assertEquals(3, l.longestArithSeqLength(nums));
    }

    @Test
    public void sampleInput3() {
        nums = new int[]{20, 1, 15, 3, 10, 5, 8};
        assertEquals(4, l.longestArithSeqLength(nums));
    }
}
