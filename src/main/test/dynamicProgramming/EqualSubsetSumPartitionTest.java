package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EqualSubsetSumPartitionTest {
    private EqualSubsetSumPartition equalSubsetSum = new EqualSubsetSumPartition();

    @Test
    public void sampleInput1() {
        assertTrue(equalSubsetSum.canPartition(new int[] {1, 2, 3, 4}));
    }

    @Test
    public void sampleInput2() {
        assertTrue(equalSubsetSum.canPartition(new int[] {1, 1, 3, 4, 7}));
    }

    @Test
    public void sampleInput3() {
        assertFalse(equalSubsetSum.canPartition(new int[] {2, 3, 4, 6}));
    }
}
