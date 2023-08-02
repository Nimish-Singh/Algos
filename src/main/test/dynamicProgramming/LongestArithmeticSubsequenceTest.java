package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestArithmeticSubsequenceTest {
    private final LongestArithmeticSubsequence las = new LongestArithmeticSubsequence();
    private int[] arr;

    @Test
    public void sampleInput1() {
        arr = new int[]{1, 2, 3, 4};
        assertEquals(4, las.longestSubsequence(arr, 1));
    }

    @Test
    public void sampleInput2() {
        arr = new int[]{1, 3, 5, 7};
        assertEquals(1, las.longestSubsequence(arr, 1));
    }

    @Test
    public void sampleInput3() {
        arr = new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1};
        assertEquals(4, las.longestSubsequence(arr, -2));
    }
}
