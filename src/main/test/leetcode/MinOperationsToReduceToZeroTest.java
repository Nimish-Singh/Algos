package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinOperationsToReduceToZeroTest {
    private MinOperationsToReduceToZero minOperations = new MinOperationsToReduceToZero();

    @Test
    public void sampleInput1() {
        assertEquals(2, minOperations.minOperations(new int[]{1, 1, 4, 2, 3}, 5));
    }

    @Test
    public void sampleInput2() {
        assertEquals(-1, minOperations.minOperations(new int[]{5, 6, 7, 8, 9}, 4));
    }

    @Test
    public void sampleInput3() {
        assertEquals(5, minOperations.minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10));
    }
}
